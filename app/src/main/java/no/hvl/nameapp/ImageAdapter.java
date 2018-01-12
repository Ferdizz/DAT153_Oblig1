package no.hvl.nameapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import no.hvl.nameapp.data.PersonDB;

public class ImageAdapter extends BaseAdapter{

    private Context context;
    private PersonDB db = PersonDB.getInstance();

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return db.count();
    }

    @Override
    public Object getItem(int i) {
        return db.getPersonByIndex(i);
    }

    @Override
    public long getItemId(int i) {
        return db.getIdByIndex(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgView = new ImageView(context);
        imgView.setImageResource(db.getAll().get(i).getPicture());
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setLayoutParams(new GridView.LayoutParams(500, 500));
        return imgView;
    }
}
