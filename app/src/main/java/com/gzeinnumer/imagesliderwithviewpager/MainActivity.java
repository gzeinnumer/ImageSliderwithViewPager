package com.gzeinnumer.imagesliderwithviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //todo 2
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 3
        viewPager = findViewById(R.id.viewPager);

        //todo 9
        AdapterViewPager adapter =  new AdapterViewPager(this);
        viewPager.setAdapter(adapter);



    }
}
