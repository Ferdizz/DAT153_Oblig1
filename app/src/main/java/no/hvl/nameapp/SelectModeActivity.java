package no.hvl.nameapp;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class SelectModeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);
    }


    public void listNames(View view){
        Intent intent = new Intent(this, ListNamesActivity.class);
        startActivity(intent);
    }

    public void openGallery(View view){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }

    public void openLearningMode(View view){
        Intent intent = new Intent(this, LearningModeActivity.class);
        startActivity(intent);
    }

    public void addPerson(View view){
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }

}
