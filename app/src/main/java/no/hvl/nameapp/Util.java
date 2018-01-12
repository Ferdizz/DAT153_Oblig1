package no.hvl.nameapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Util {

//    private Context context;

//    public Util(Context c){
//        context = c;
//    }

//    public Bitmap compressImage(Integer img) {
//
//        Bitmap original = ((BitmapDrawable) ContextCompat.getDrawable(context, img)).getBitmap();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        original.compress(Bitmap.CompressFormat.JPEG, 0, out);
//        Bitmap compressed = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
//
//        Log.e("Original size", original.getByteCount() + "");
//        Log.e("Compressed size", compressed.getByteCount() + "");
//
//        return compressed;
//    }

//    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
//
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, resId, options);
//
//        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        // Decode bitmap with inSampleSize set
//        options.inJustDecodeBounds = false;
//        Log.e("Width", options.outWidth + "");
//        Log.e("Height", options.outHeight + "");
//        return BitmapFactory.decodeResource(res, resId, options);
//    }
//
//    public int calculateInSampleSize(
//            BitmapFactory.Options options, int reqWidth, int reqHeight) {
//        // Raw height and width of image
//        final int height = options.outHeight;
//        final int width = options.outWidth;
//        int inSampleSize = 1;
//
//        if (height > reqHeight || width > reqWidth) {
//
//            final int halfHeight = height / 2;
//            final int halfWidth = width / 2;
//
//            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
//            // height and width larger than the requested height and width.
//            while ((halfHeight / inSampleSize) >= reqHeight
//                    && (halfWidth / inSampleSize) >= reqWidth) {
//                inSampleSize *= 2;
//            }
//        }
//
//        return inSampleSize;
//    }

    public Bitmap getDecodedBitmap(Resources res, int resId){
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 4;
        return BitmapFactory.decodeResource(res, resId, opts);
    }

}
