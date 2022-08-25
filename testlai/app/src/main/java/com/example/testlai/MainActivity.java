package com.example.testlai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView poin;
    SeekBar sar1,sar2,sar3;
    CheckBox check1,check2,check3;
    ImageButton button;
    public void call(){
        poin = (TextView) findViewById(R.id.poin);
        sar1 = (SeekBar) findViewById(R.id.sar1);
        sar2 = (SeekBar) findViewById(R.id.sar2);
        sar3 = (SeekBar) findViewById(R.id.sar3);
        check1 =(CheckBox) findViewById(R.id.check1);
        check2 =(CheckBox) findViewById(R.id.check2);
        check3 =(CheckBox) findViewById(R.id.check3);
        button = (ImageButton) findViewById(R.id.play);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // start
        call();
        CountDownTimer countDownTimer = new CountDownTimer(60000,200) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                int num1=random.nextInt(5);
                int num2=random.nextInt(5);
                int num3=random.nextInt(5);
                if(sar3.getProgress()>=sar3.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"and",Toast.LENGTH_SHORT).show();
                }
                sar3.setProgress(sar3.getProgress()+num3);
                sar2.setProgress(sar2.getProgress()+num2);
                sar1.setProgress(sar1.getProgress()+num1);
            }

            @Override
            public void onFinish() {

            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sar1.setProgress(0);
                sar2.setProgress(0);
                sar3.setProgress(0);
                button.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }
}