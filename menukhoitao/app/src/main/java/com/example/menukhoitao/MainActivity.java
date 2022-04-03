package com.example.menukhoitao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button menupo;
    ConstraintLayout manhinh;
    Button contextmn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menupo =(Button) findViewById(R.id.buttonmenu);
        contextmn = (Button) findViewById(R.id.contextbtn);
        manhinh = (ConstraintLayout)findViewById(R.id.manhinh);
        menupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showmenu();
            }
        });
        registerForContextMenu(contextmn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private  void showmenu(){
        PopupMenu popupMenu = new PopupMenu(this,menupo);
        popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.add:
                        break;
                    case  R.id.update:
                        break;
                    case R.id.delete:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                break;
            case R.id.email:
                break;
            case R.id.share:
                break;
            case R.id.search:
                break;
            case R.id.phone:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contex_menu,menu);
        menu.setHeaderTitle("chọn màu");
        menu.setHeaderIcon(R.mipmap.ic_launcher_round);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.yellow:
                manhinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.red:
                manhinh.setBackgroundColor(Color.RED);
                break;
            case R.id.bule:
                manhinh.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}