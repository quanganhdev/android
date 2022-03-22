package com.example.drawblecutom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView2);
        btn = (Button) findViewById(R.id.button2);
        img.setImageLevel(1000);
        ClipDrawable clipDrawable = (ClipDrawable) img.getDrawable();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int curent= clipDrawable.getLevel();
                if(curent>=10000){
                    curent=0;
                }
       img.setImageLevel(curent+1000);
            }
        });
    }
}