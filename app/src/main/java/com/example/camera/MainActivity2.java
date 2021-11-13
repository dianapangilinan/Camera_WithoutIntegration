package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TextView tvHeader2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvHeader2 = (TextView) findViewById(R.id.tvHeader2);
        tvHeader2.setMovementMethod(new ScrollingMovementMethod());
        configureNextButton();
    }
    private void configureNextButton(){
        Button btn_NextActivity = (Button) findViewById(R.id.btnNextActivity);
        btn_NextActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, showImg.class));
            }


        });
    }
}