package no.hvl.nameapp;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import no.hvl.nameapp.data.PersonDB;

public class ImageAdapter extends BaseAdapter{

    private Context context;
    private Util util = new Util();
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

        int pixels = getScreenWidth() / 3;

        ImageView imgView;
        if(view == null){
            imgView = new ImageView(context);
            imgView.setLayoutParams(new GridView.LayoutParams(pixels, pixels));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else{
            imgView = (ImageView) view;
        }

        imgView.setImageURI(db.getAll().get(i).getImageURI());

        return imgView;

    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

}
