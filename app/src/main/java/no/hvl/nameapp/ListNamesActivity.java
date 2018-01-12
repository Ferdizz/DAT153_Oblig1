package no.hvl.nameapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import no.hvl.nameapp.data.Person;

public class ListNamesActivity extends ListActivity {

    // placeholder data
    private final Person[] LIST = new Person[] {new Person(null,"Per"),
            new Person(null,"Pål"), new Person(null,"Espen"),
            new Person(null,"Geir"), new Person(null,"Trude"),
            new Person(null,"Ole"), new Person(null,"Tim"),
            new Person(null,"Stine"), new Person(null,"Ingrid"),
            new Person(null,"Tine"), new Person(null,"Bente"),
            new Person(null,"Jimmy"), new Person(null,"Mona")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_names);

        //shady method to generate list items from array
        setListAdapter(new ArrayAdapter<>(this,R.layout.list_item_view, LIST));
        getListView().setTextFilterEnabled(true);
    }
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // placeholder click event
        new AlertDialog.Builder(this)
                .setTitle("" + getListView().getItemAtPosition(position))
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                .show();
    }

}
