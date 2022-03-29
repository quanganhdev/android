package com.example.changelanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,email;
    TextView toaftext;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxxa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten =  name.getText().toString();
                String dt =phone.getText().toString();
                String mail = email.getText().toString();
                String texchaoban=getResources().getString(R.string.text_chaoban);
                toaftext.setText(texchaoban+hoten);
            }
        });

    }
    public void  anhxxa(){
        name= (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.Phone);
        email = (EditText) findViewById(R.id.email);
        toaftext =(TextView) findViewById(R.id.texttt);
        btn = (Button) findViewById(R.id.button);
    }

}