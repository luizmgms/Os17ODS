package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class Obj17Activity extends AppCompatActivity implements View.OnClickListener, YouTubePlayer.OnInitializedListener{

    private Toolbar toolbar;
    private ImageView imageOf17Obj1;
    private TextView legendImage117Obj;
    private ImageView imageOf17Obj2;
    private TextView legendImage217Obj;
    private TextView textNewspt;
    private YouTubePlayerFragment youTubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    private TextView textLinkDocument;
    private TextView textLinkDuvidas;
    private ImageView imageDuvidas;
    private TextView textLinkDados, textLinkSaiba, textLinkAcomp, textLinkPageEsp, textLinkDocsTema;
    private TextView textLinkTempReal, textLinkAgendPt, textLinkAgendIng, textLinkInicadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_obj17);

        //Set Toolbar
        toolbar = findViewById(R.id.toolbarInObj17Id);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(getResources().getString(R.string.title_17_obj));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Obj17Activity.super.onBackPressed();
            }
        });

        imageOf17Obj1 = findViewById(R.id.imageOf17Obj1Id);
        legendImage117Obj = findViewById(R.id.legendImage117ObjId);
        imageOf17Obj2 = findViewById(R.id.imageOf17Obj2Id);
        legendImage217Obj = findViewById(R.id.legendImage217ObjId);
        textNewspt = findViewById(R.id.textNoticiasId);
        textLinkDocument = findViewById(R.id.textLinkDocumentId);
        imageDuvidas = findViewById(R.id.imageDuvidasId);
        textLinkDuvidas = findViewById(R.id.textLinkDuvidasId);
        textLinkDados = findViewById(R.id.textLinkDadosId);
        textLinkSaiba = findViewById(R.id.textLinkSaibaId);
        textLinkAcomp = findViewById(R.id.textLinkAcompId);
        textLinkPageEsp = findViewById(R.id.textLinkPageEspId);
        textLinkDocsTema = findViewById(R.id.textLinkDocsTemaId);
        textLinkTempReal = findViewById(R.id.textLinkTempRealId);
        textLinkAgendPt = findViewById(R.id.textLinkAgendPtId);
        textLinkAgendIng = findViewById(R.id.textLinkAgendIngId);
        textLinkInicadores = findViewById(R.id.textLinkInicadoresId);


        imageOf17Obj1.setOnClickListener(this);
        legendImage117Obj.setOnClickListener(this);
        imageOf17Obj2.setOnClickListener(this);
        legendImage217Obj.setOnClickListener(this);
        textNewspt.setOnClickListener(this);
        textLinkDocument.setOnClickListener(this);
        imageDuvidas.setOnClickListener(this);
        textLinkDuvidas.setOnClickListener(this);
        textLinkDados.setOnClickListener(this);
        textLinkSaiba.setOnClickListener(this);
        textLinkAcomp.setOnClickListener(this);
        textLinkPageEsp.setOnClickListener(this);
        textLinkDocsTema.setOnClickListener(this);
        textLinkTempReal.setOnClickListener(this);
        textLinkAgendPt.setOnClickListener(this);
        textLinkAgendIng.setOnClickListener(this);
        textLinkInicadores.setOnClickListener(this);

        //Set PlayerYouTube
        youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youTubeFragmentIn17ObjId);
        youTubePlayerFragment.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageOf17Obj1Id:
            case R.id.legendImage117ObjId:
                startUrl(getResources().getString(R.string.link_of_image_1_of_obj17));
                break;
            case R.id.imageOf17Obj2Id:
            case R.id.legendImage217ObjId:
                startUrl(getResources().getString(R.string.link_of_image_2_of_obj17));
                break;
            case R.id.textNoticiasId:
                startUrl(getResources().getString(R.string.link_noticias_pt_of_obj17));
                break;
            case R.id.textLinkDocumentId:
                startUrl(getResources().getString(R.string.link_document_of_obj17));
                break;
            case R.id.imageDuvidasId:
            case R.id.textLinkDuvidasId:
                startUrl(getResources().getString(R.string.link_duvidas_of_obj17));
                break;
            case R.id.textLinkDadosId:
                startUrl(getResources().getString(R.string.link_dados_of_obj17));
                break;
            case R.id.textLinkSaibaId:
                startUrl(getResources().getString(R.string.link_saiba_of_obj17));
                break;
            case R.id.textLinkAcompId:
                startUrl(getResources().getString(R.string.link_acomp_of_obj17));
                break;
            case R.id.textLinkPageEspId:
                startUrl(getResources().getString(R.string.link_page_esp_of_obj17));
                break;
            case R.id.textLinkTempRealId:
                startUrl(getResources().getString(R.string.link_temp_real_of_obj17));
                break;
            case R.id.textLinkAgendPtId:
                startUrl(getResources().getString(R.string.link_agend_pt_of_obj17));
                break;
            case R.id.textLinkAgendIngId:
                startUrl(getResources().getString(R.string.link_agend_ing_of_obj17));
                break;
            case R.id.textLinkInicadoresId:
                startUrl(getResources().getString(R.string.link_indi_of_obj17));
                break;
            case R.id.textLinkDocsTemaId:
                startUrl(getResources().getString(R.string.link_docs_tem_of_obj17));
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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer ytPlayer, boolean wasRestored) {
        youTubePlayer = ytPlayer;

        //Enables automatic control of orientation
        youTubePlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //System controls will appear automatically
        youTubePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if (!wasRestored) {
            youTubePlayer.cueVideo(getResources().getString(R.string.video_yt_obj17));
        }
        else
        {
            youTubePlayer.play();
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        youTubePlayer = null;
    }
}
