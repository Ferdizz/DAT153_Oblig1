package no.hvl.nameapp;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
    private Context context;
    private Util util = new Util();

    public Integer[] images = {
            R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
    };

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        int pixels = getScreenWidth() / 3;
//        Log.i("Width", pixels + "");

        ImageView imgView;
        if(view == null){
            imgView = new ImageView(context);
            imgView.setLayoutParams(new GridView.LayoutParams(pixels, pixels));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8,8,8,8);
        }else{
            imgView = (ImageView) view;
        }

//        imgView.setImageResource(images[i]);
//        imgView.setImageBitmap(
//                util.decodeSampledBitmapFromResource(context.getResources(), images[i], pixels, pixels)
//        );
        imgView.setImageBitmap(util.getDecodedBitmap(context.getResources(), images[i]));
        return imgView;

//        imgView.setImageBitmap(util.compressImage(images[i]));
    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

}
