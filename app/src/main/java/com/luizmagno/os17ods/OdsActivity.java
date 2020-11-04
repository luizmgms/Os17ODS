package com.luizmagno.os17ods;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class OdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_ods);

        String num_ods = "0";
        Bundle extras = getIntent().getExtras();
        if (extras != null ) {
            num_ods = extras.getString("idOds");
        }

        int numOds = Integer.parseInt(num_ods);

        ArrayList<Integer> listOds = new ArrayList<>();
        for (int i=0; i<18; i++) {
            listOds.add(i);
        }

        ViewPager viewPager = findViewById(R.id.viewPagerOdsId);
        PagerAdapter pagerAdapter = new ViewPagerOdsAdapter( getSupportFragmentManager(), 0,listOds, this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(numOds);

    }

}
