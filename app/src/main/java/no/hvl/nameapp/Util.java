package no.hvl.nameapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Util {
    public static Bitmap getDecodedBitmap(Resources res, int resId){
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 4;
        return BitmapFactory.decodeResource(res, resId, opts);
    }
}

