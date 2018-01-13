package no.hvl.nameapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import no.hvl.nameapp.data.Person;
import no.hvl.nameapp.data.PersonDB;

public class ListNamesActivity extends ListActivity {

    private PersonDB db = PersonDB.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_names);

        //shady method to generate list items from array
        setListAdapter(new ArrayAdapter<>(this,R.layout.list_item_view, db.getAll()));
        getListView().setTextFilterEnabled(true);

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(getApplicationContext(), ViewPersonActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);

    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, AddPersonActivity.class);
        startActivity(intent);
    }

}
