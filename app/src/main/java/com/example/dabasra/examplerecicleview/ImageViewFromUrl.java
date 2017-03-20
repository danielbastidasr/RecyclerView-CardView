package com.example.dabasra.examplerecicleview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by dabasra .
 */

public class ImageViewFromUrl extends AsyncTask<Void, Void, Drawable>{
    private final ImageView imageView;
    private final String url;
    public ImageViewFromUrl(ImageView imageView, String url) {
        this.imageView = imageView;
        this.url = url;
    }


    @Override
    protected Drawable doInBackground(Void... voids) {
        Drawable drawable = null;
        try {
            drawable = drawable_from_url(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawable;
    }


    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        if(drawable != null){
            imageView.setImageDrawable(drawable);
        }
        else Log.d("ImageView", "onPostExecute: "+ "Drawable is null");
    }

    public Drawable drawable_from_url(String url)  throws  java.io.IOException  {

        Bitmap bm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        bm = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(null,bm);
    }


}
