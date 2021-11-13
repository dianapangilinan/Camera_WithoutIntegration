package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class showImg extends AppCompatActivity {

    Camera camera;
    ImageView imageView;
    showCamera showCamera;
    FrameLayout frameLayout;
    Button btnCaptureImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_img);

        imageView = findViewById(R.id.viewImg);
        btnCaptureImg = findViewById(R.id.btnCaptureImg);

        if(ContextCompat.checkSelfPermission(showImg.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(showImg.this,
                    new String[]{Manifest.permission.CAMERA}, 101);
        }
        btnCaptureImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 101);

            }
        });
    }
    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(reqCode, resCode, data);

        if (resCode == RESULT_OK) {
            if (reqCode == 101) {
                if (data != null) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    /* Passing BITMAP to the Second Activity */
                    Intent IntentCamera = new Intent(this, captureImg.class);
                    IntentCamera.putExtra("BitmapImage", photo);
                    startActivity(IntentCamera);
                }
            } else {
                if (data != null) {
                    Uri selectedImgUri = data.getData();
                    /* Passing ImageURI to the Second Activity */
                    Intent IntentGallery = new Intent(this, captureImg.class);
                    IntentGallery.setData(selectedImgUri);
                    startActivity(IntentGallery);
                }
            }
        }
    }
}