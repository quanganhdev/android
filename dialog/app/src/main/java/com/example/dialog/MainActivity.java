package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvname;
    ArrayList <String> array;
    ArrayAdapter arrayAdapter;
    TextView dangnhap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvname= (ListView) findViewById(R.id.lis_view);
        array= new ArrayList<>();
        addtoarray();
        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,array);
        lvname.setAdapter(arrayAdapter);
        lvname.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xacnhanxoa(i);
                return false;
            }
        });
    }

    public void addtoarray(){
        array.add("android");
        array.add("php");
        array.add("ios");
        array.add("react js");
        array.add("html css");
        array.add("java");
        array.add("c#");
        array.add("java scrip");
    }
    public  void xacnhanxoa(int position){
        AlertDialog.Builder alerdialog = new AlertDialog.Builder(this);
        alerdialog.setTitle("xac nhan");
        alerdialog.setIcon(R.mipmap.ic_launcher);
        alerdialog.setMessage("ban cos muon xoa mon hoc nay khong");
        alerdialog.setPositiveButton("co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                array.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        alerdialog.setNegativeButton("khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
   alerdialog.show();


    }
}