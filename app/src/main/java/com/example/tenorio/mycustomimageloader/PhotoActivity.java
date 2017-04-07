package com.example.tenorio.mycustomimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        // README
        // 1. Download an image url and put into ImageView
        // 2. Download, resize width and put into ImageView
        // API
        // Dolphin.load("http://", imageView);
        // Dolphin.load("http://" 200, 300, imageView);
        // Dolphin.load("http://" 200, 300, new DolphinCallback() {
        //     public void onSuccess(Bitmap bitmap) {
        //         imageView.setImageBitmap(bitmap);
        //     }
        // })
        String url = "http://i.imgur.com/tGbaZCY.jpg";
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        Dolphin.load(url, ivPhoto);
    }
}
