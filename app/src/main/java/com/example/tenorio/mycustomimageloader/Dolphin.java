package com.example.tenorio.mycustomimageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tenorio on 4/6/17.
 */

public class Dolphin {
    public static void load(String imageUrl, ImageView imageView) {
        // 1. check internet connection
        // 2. make network request to url
        // 3. receive the bytes
        // 4. turn them into bitmap
        new DolphinTask(imageView).execute(imageUrl);
    }

    public static class DolphinTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DolphinTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                InputStream in = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                in.close();

                return bitmap;
            } catch(IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
