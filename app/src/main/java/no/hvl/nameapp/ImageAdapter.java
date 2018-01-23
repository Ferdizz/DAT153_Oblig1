package no.hvl.nameapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import no.hvl.nameapp.data.PersonDB;

public class ImageAdapter extends BaseAdapter {

    private PersonDB db = PersonDB.getInstance();

    public ImageAdapter() {
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
    public View getView(int i, View view, ViewGroup parent) {

        ImageView imgView;
        int pixels = getScreenWidth() / 3;

        if (view == null) {
            imgView = new ImageView(parent.getContext());
            imgView.setLayoutParams(new GridView.LayoutParams(pixels, pixels));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imgView = (ImageView) view;
        }

        Uri uri = db.getAll().get(i).getImageURI();
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 4;

        try {
            InputStream is = parent.getContext().getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(is, null, opts);
            imgView.setImageBitmap(bitmap);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imgView;
    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

}
