package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class AgendaActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{

    private TextView textLink;
    private YouTubePlayerFragment youTubePlayerFragment1;
    private YouTubePlayer youTubePlayer1;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_agenda);

        //Set Toolbar
        toolbar = findViewById(R.id.toolbarInAgendaId);
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
        textLink = findViewById(R.id.textLinkPlaylistAgendaId);
        textLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getResources().getString(R.string.link_playslist);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //Set PlayerYouTube
        youTubePlayerFragment1 = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youTubeFragmentId);
        youTubePlayerFragment1.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer ytPlayer, boolean wasRestored) {

        youTubePlayer1 = ytPlayer;

        //Enables automatic control of orientation
        youTubePlayer1.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //System controls will appear automatically
        youTubePlayer1.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if (!wasRestored) {
            youTubePlayer1.cueVideo(getResources().getString(R.string.video_yt_agenda_1));
        }
        else
        {
            youTubePlayer1.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        youTubePlayer1 = null;
    }
}