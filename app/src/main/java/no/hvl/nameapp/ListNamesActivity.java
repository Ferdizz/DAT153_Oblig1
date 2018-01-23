package no.hvl.nameapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import no.hvl.nameapp.data.PersonDB;

public class ListNamesActivity extends AppCompatActivity {

    private PersonDB db = PersonDB.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_names);

        //shady method to generate list items from array
        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(new ArrayAdapter<>(this,R.layout.list_item_view, db.getAll()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ViewPersonActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });
        lv.setTextFilterEnabled(true);

    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }

}
