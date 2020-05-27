package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CupulaActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private ImageView video1, video2, video3;
    private TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cupula);

        //set toolbar
        toolbar = findViewById(R.id.toolbarInCupulaId);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CupulaActivity.super.onBackPressed();
            }
        });

        //set Videos e Text
        video1 = findViewById(R.id.videoTransId);
        video2 = findViewById(R.id.videoQualoMId);
        video3 = findViewById(R.id.videoQeDesSusId);
        link = findViewById(R.id.textLinkAcessAgendId);

        video1.setOnClickListener(this);
        video2.setOnClickListener(this);
        video3.setOnClickListener(this);
        link.setOnClickListener(this);




    }

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
