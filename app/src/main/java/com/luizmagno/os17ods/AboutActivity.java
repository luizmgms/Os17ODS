package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView logoGitHub, logoInst, logoTwitter, logoYouTube, logoFace, logoFlickr, logoVim, logoTrello;
    private TextView textAcessPageOnuBr, textLogoGitHub;
    private Button buttonAvalieApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about);

        logoGitHub = findViewById(R.id.logoGitHubId);
        logoInst = findViewById(R.id.logoInstaOnuBrId);
        logoTwitter = findViewById(R.id.logoTwitterOnuBrId);
        logoYouTube = findViewById(R.id.logoYouTubeOnuBrId);
        logoFace = findViewById(R.id.logoFaceOnuBrId);
        logoFlickr = findViewById(R.id.logoFlickrOnuBrId);
        logoVim = findViewById(R.id.logoVimeoOnuBrId);
        logoTrello = findViewById(R.id.logoTrelloOnuBrId);
        textAcessPageOnuBr = findViewById(R.id.textLinkPageAboutId);
        textLogoGitHub = findViewById(R.id.textLinkLogoGitId);
        buttonAvalieApp = findViewById(R.id.buttonAvaliaAppId);

        logoGitHub.setOnClickListener(this);
        logoInst.setOnClickListener(this);
        logoTwitter.setOnClickListener(this);
        logoYouTube.setOnClickListener(this);
        logoFace.setOnClickListener(this);
        logoFlickr.setOnClickListener(this);
        logoVim.setOnClickListener(this);
        logoTrello.setOnClickListener(this);
        textAcessPageOnuBr.setOnClickListener(this);
        textLogoGitHub.setOnClickListener(this);
        buttonAvalieApp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textLinkPageAboutId:
                openUrl(getResources().getString(R.string.link_acess_agend));
                break;
            case R.id.logoGitHubId:
            case R.id.textLinkLogoGitId:
                openUrl(getResources().getString(R.string.link_git_app));
                break;
            case R.id.buttonAvaliaAppId:
                openUrl(getResources().getString(R.string.link_of_play_store));
                break;
            case R.id.logoInstaOnuBrId:
                openUrl(getResources().getString(R.string.link_instagram_onu));
                break;
            case R.id.logoTwitterOnuBrId:
                openUrl(getResources().getString(R.string.link_twitter_onu));
                break;
            case R.id.logoYouTubeOnuBrId:
                openUrl(getResources().getString(R.string.link_youtube_onu));
                break;
            case R.id.logoFaceOnuBrId:
                openUrl(getResources().getString(R.string.link_facebook_onu));
                break;
            case R.id.logoFlickrOnuBrId:
                openUrl(getResources().getString(R.string.link_flickr_onu));
                break;
            case R.id.logoVimeoOnuBrId:
                openUrl(getResources().getString(R.string.link_vimeo_onu));
                break;
            case R.id.logoTrelloOnuBrId:
                openUrl(getResources().getString(R.string.link_trello_onu));
                break;
            default:
                break;
        }
    }

    private void openUrl (String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
