package no.hvl.nameapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;

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

        /*  TODO: komprimerer bilder i galleriet, men det er noe galt med permissions, så det krasjer
              etter at det blir lagt til eksterne bilder.

        try {
            final int THUMBNAIL_SIZE = 256;
            Uri imageUri = db.getAll().get(i).getImageURI()
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), imageUri);
            bitmap = Bitmap.createScaledBitmap(bitmap, THUMBNAIL_SIZE, THUMBNAIL_SIZE, false);
            imgView.setImageBitmap(bitmap)
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        return imgView;

    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

}
