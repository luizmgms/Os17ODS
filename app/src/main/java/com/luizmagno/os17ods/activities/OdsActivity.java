package com.luizmagno.os17ods.activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.luizmagno.os17ods.R;
import com.luizmagno.os17ods.adapters.ViewPagerOdsAdapter;
import com.luizmagno.os17ods.utils.ZoomOutPageTransformer;

import java.util.ArrayList;

import static com.luizmagno.os17ods.utils.Utilities.getIdsOfAttribOds;

public class OdsActivity extends AppCompatActivity {

    FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_ods);

        int num_ods = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null ) {
            num_ods = extras.getInt("pos");
        }

        ArrayList<Integer> listOds = new ArrayList<>();
        for (int i=0; i<18; i++) {
            listOds.add(i);
        }

        final ViewPager viewPager = findViewById(R.id.viewPagerOdsId);
        final ViewPagerOdsAdapter pagerAdapter = new ViewPagerOdsAdapter(
                getSupportFragmentManager(), 0,listOds, this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(num_ods);
        viewPager.addOnPageChangeListener(onPageChangeListener());
        //Set Animação de Transição
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        fabShare = findViewById(R.id.fabShareId);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] id = getIdsOfAttribOds(viewPager.getCurrentItem());
                share(id[4]);
            }
        });

    }

    private ViewPager.OnPageChangeListener onPageChangeListener() {
        return (new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int idColor = ContextCompat.getColor(OdsActivity.this, getIdsOfAttribOds(position)[3]);
                fabShare.setBackgroundTintList(ColorStateList.valueOf(idColor));
            }
            @Override
            public void onPageSelected(int position) { }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
    }

    private void share(int id) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(id));
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(
                sendIntent, getResources().getString(R.string.share_with));
        startActivity(shareIntent);

    }

}
