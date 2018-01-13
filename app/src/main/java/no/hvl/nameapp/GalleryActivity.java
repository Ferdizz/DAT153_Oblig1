package no.hvl.nameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {

                Intent intent = new Intent(getApplicationContext(), ViewPersonActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);

            }
        });

    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }
}
