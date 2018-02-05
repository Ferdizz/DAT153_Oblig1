package no.hvl.nameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import no.hvl.nameapp.data.PersonDB;

public class ListNamesActivity extends AppCompatActivity {

    private PersonDB db = PersonDB.getInstance();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_names);

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(adapter = new ArrayAdapter<>(this, R.layout.list_item_view, db.getAll()));
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

    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
        finish();
    }

}
