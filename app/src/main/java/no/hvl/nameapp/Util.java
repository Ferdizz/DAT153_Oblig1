package no.hvl.nameapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Util {

    private Context context;

    public Util(Context c){
        context = c;
    }

    public Bitmap compressImage(Integer img) {

        Bitmap original = ((BitmapDrawable) ContextCompat.getDrawable(context, img)).getBitmap();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        original.compress(Bitmap.CompressFormat.JPEG, 0, out);
        Bitmap compressed = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));

        Log.e("Original size", original.getByteCount() + "");
        Log.e("Compressed size", compressed.getByteCount() + "");

        return compressed;
    }

}
