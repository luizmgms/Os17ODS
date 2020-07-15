package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AgendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agenda);

        //Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInAgendaId);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(getResources().getString(R.string.title_agenda));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgendaActivity.super.onBackPressed();
            }
        });

        //Set Text
        TextView textLink = findViewById(R.id.textLinkPlaylistAgendaId);
        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(getResources().getString(R.string.link_playslist));
            }
        });

        //Set Video
        ImageView videoAgenda = findViewById(R.id.videoAgendaId);
        videoAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(getResources().getString(R.string.link_video_agenda_1));
            }
        });

    }

    private void openUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}