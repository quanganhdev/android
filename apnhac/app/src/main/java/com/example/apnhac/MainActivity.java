package com.example.apnhac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.apnhac.R;
import com.example.apnhac.adapter.mainviewpaperadater;
import com.example.apnhac.fragment.fragment_tim_kiem;
import com.example.apnhac.fragment.fragment_trang_chu;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        inti();
    }
    private void  inti(){
    mainviewpaperadater mainviewpaperadater = new mainviewpaperadater(getSupportFragmentManager());
    mainviewpaperadater.addfragment(new fragment_trang_chu(),"trang chu");
    mainviewpaperadater.addfragment(new fragment_tim_kiem(),"tim kiem");
    viewPager.setAdapter(mainviewpaperadater);
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
    tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }
    public void anhxa(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpaper);
    }
}