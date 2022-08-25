package com.example.laitudau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView poin;
    SeekBar sar1,sar2,sar3;
    CheckBox check1,check2,check3;
    ImageButton button;
    int point=100;
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
    private void enable(){
        check1.setEnabled(true);
        check2.setEnabled(true);
        check3.setEnabled(true);
    }
    private void disble(){
        check1.setEnabled(false);
        check2.setEnabled(false);
        check3.setEnabled(false);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game1);
        call();
        poin.setText(String.valueOf(point));

        // start
        CountDownTimer countDownTimer = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                    Random random = new Random();
                    int num1=random.nextInt(7);
                    int num2=random.nextInt(7);
                    int num3=random.nextInt(7);
                    if (sar3.getProgress()>=sar3.getMax()){
                        this.cancel();
                        Toast.makeText(MainActivity.this,"and 3",Toast.LENGTH_SHORT).show();
                        button.setVisibility(View.VISIBLE);
                        if (check3.isChecked()){
                            point+=10;
                            Toast.makeText(MainActivity.this,"you win",Toast.LENGTH_SHORT).show();
                            poin.setText(String.valueOf(point));
                        }else {
                            point-=5;
                            Toast.makeText(MainActivity.this,"you lose",Toast.LENGTH_SHORT).show();
                            poin.setText(String.valueOf(point));
                        }

                    }
                if (sar2.getProgress()>=sar2.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"and 2",Toast.LENGTH_SHORT).show();
                    if (check2.isChecked()){
                        point+=10;
                        Toast.makeText(MainActivity.this,"you win",Toast.LENGTH_SHORT).show();
                        poin.setText(String.valueOf(point));
                    }else {
                        point-=5;
                        Toast.makeText(MainActivity.this,"you lose",Toast.LENGTH_SHORT).show();
                        poin.setText(String.valueOf(point));
                    }
                }
                if (sar1.getProgress()>=sar1.getMax()){
                    this.cancel();
                    button.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"and 1",Toast.LENGTH_SHORT).show();
                    if (check1.isChecked()){
                        point+=10;
                        Toast.makeText(MainActivity.this,"you win",Toast.LENGTH_SHORT).show();
                        poin.setText(String.valueOf(point));
                    }else {
                        point-=5;
                        Toast.makeText(MainActivity.this,"you lose",Toast.LENGTH_SHORT).show();
                        poin.setText(String.valueOf(point));
                    }
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
                if (check1.isChecked()||check2.isChecked()||check3.isChecked()){
                    sar1.setProgress(0);
                    sar2.setProgress(0);
                    sar3.setProgress(0);
                    button.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                }else {
                    Toast.makeText(MainActivity.this,"check",Toast.LENGTH_SHORT).show();
                }

            }
        });
            check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){
                        check2.setChecked(false);
                        check3.setChecked(false);
                    }
                }
            });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    check1.setChecked(false);
                    check3.setChecked(false);
                }
            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    check1.setChecked(false);
                    check2.setChecked(false);
                }
            }
        });
    }





}