package no.hvl.nameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class ViewPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);

        Intent intent = getIntent();

        PersonDB db = PersonDB.getInstance();
        Person p = db.getPersonById(intent.getLongExtra("ID", 0));

        if(p != null){
            ImageView imgView = (ImageView) findViewById(R.id.profilePicture);
            TextView textView = (TextView) findViewById(R.id.profileName);

            textView.setText(p.getName());
            imgView.setImageBitmap(p.getPicture());
        }

    }
}
