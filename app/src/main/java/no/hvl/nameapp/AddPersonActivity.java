package no.hvl.nameapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;


public class AddPersonActivity extends AppCompatActivity {

    private PersonDB db = PersonDB.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
    }

    public void requestImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"),1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null){
            InputStream is = null;
            try {
                is = getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            ImageView iv = findViewById(R.id.imageView);
            iv.setImageBitmap(bitmap);
        } else {
            // TODO:
        }
    }

    public void addPerson(View view) {
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        EditText editText = (EditText) findViewById(R.id.editText);
        String str =  editText.getText().toString();
        Bitmap b = ((BitmapDrawable) iv.getDrawable()).getBitmap();
        Person p = new Person(b,str);
        db.addPerson(p);
        Intent intent = new Intent(this, ListNamesActivity.class);
        startActivity(intent);
    }

}
