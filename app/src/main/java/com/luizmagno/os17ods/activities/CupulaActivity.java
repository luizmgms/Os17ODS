package com.luizmagno.os17ods.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luizmagno.os17ods.R;

public class CupulaActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cupula);

        //set toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInCupulaId);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CupulaActivity.super.onBackPressed();
            }
        });

        //set Videos e Text
        ImageView video1 = findViewById(R.id.videoTransId);
        ImageView video2 = findViewById(R.id.videoQualoMId);
        ImageView video3 = findViewById(R.id.videoQeDesSusId);
        ImageView video4 = findViewById(R.id.videoObjGlobId);
        TextView link = findViewById(R.id.textLinkAcessAgendId);

        video1.setOnClickListener(this);
        video2.setOnClickListener(this);
        video3.setOnClickListener(this);
        video4.setOnClickListener(this);
        link.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.videoTransId:
                startUrl(getResources().getString(R.string.link_video_trans));
                break;
            case R.id.videoQualoMId:
                startUrl(getResources().getString(R.string.link_video_qual));
                break;
            case R.id.videoQeDesSusId:
                startUrl(getResources().getString(R.string.link_video_que));
                break;
            case R.id.textLinkAcessAgendId:
                startUrl(getResources().getString(R.string.link_acess_agend));
                break;
            case R.id.videoObjGlobId:
                startUrl(getResources().getString(R.string.link_video_obj_glob));
            default:
                break;
        }
    }

    private void startUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
