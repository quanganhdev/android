package com.example.customdailog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (TextView) findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailoglogin();
            }
        });
    }
    private void dailoglogin(){
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.dailoglayout);

        // ánh xạ
        final EditText user = (EditText) dialog.findViewById(R.id.usename);
        final EditText pass= (EditText) dialog.findViewById(R.id.password);
        Button login = (Button) dialog.findViewById(R.id.dongy);
        Button huy = (Button) dialog.findViewById(R.id.huy);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= user.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(username.equals("quanganh") && password.equals("1234")){
                    Toast.makeText(MainActivity.this,"đăng nhập thành công",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this,"đăng nhập không thành công",Toast.LENGTH_SHORT).show();

                }
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.cancel();
            }
        });
        dialog.show();
    }
}