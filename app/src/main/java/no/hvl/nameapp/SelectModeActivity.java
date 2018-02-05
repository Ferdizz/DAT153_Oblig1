package no.hvl.nameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SelectModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);

        // Retrieve preferences
        SharedPreferences settings = getPreferences(0);
        String owner = settings.getString("name", "");
        Log.e("NAME: ", owner);

        if (owner.isEmpty()) {

            Intent intent = new Intent(this, AddPersonActivity.class);
            intent.putExtra("setOwner", true);
            startActivity(intent);

        }
    }

    public void listNames(View view) {
        Intent intent = new Intent(this, ListNamesActivity.class);
        startActivity(intent);
    }

    public void openGallery(View view) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void openLearningMode(View view) {
        Intent intent = new Intent(this, LearningModeActivity.class);
        startActivity(intent);
    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }

}
