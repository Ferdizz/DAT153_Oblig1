package no.hvl.nameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class SelectModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);

        // Retrieve preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String name = prefs.getString("owner", "");

        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(),R.string.no_owner, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, AddPersonActivity.class);
            intent.putExtra("setOwner", true);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(),"Welcome back, " + name, Toast.LENGTH_LONG).show();
            PersonDB db = PersonDB.getInstance();
            Person p = new Person(null, name);
            db.addPerson(p);
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
