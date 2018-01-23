package no.hvl.nameapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class AddPersonActivity extends AppCompatActivity {

    private PersonDB db = PersonDB.getInstance();
    private String imagePath;
    private Uri uri;

    static final int REQUEST_CAMERA = 1;
    static final int REQUEST_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
    }

    public void captureImage(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            File imageFile = null;
            try {
                imageFile = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(imageFile != null){
                uri = FileProvider.getUriForFile(this, "no.hvl.nameapp.fileprovider", imageFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        }
    }

    public void selectImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"), REQUEST_GALLERY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null && resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_GALLERY) {
                uri = data.getData();
            }
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageURI(uri);
        }
    }

    public void addPerson(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), R.string.no_name, Toast.LENGTH_LONG).show();
        } else {
            Person p = new Person(uri, name);
            db.addPerson(p);

            Intent intent = new Intent(this, ListNamesActivity.class);
            startActivity(intent);
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "JPEG_" + timeStamp + "_";

        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(fileName, ".jpg", storageDir);

        imagePath = image.getAbsolutePath();
        return image;
    }

}
