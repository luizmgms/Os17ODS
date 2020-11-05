package com.luizmagno.os17ods.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.luizmagno.os17ods.R;

public class Obj17Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_obj17);

        //Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarInObj17Id);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(getResources().getString(R.string.title_17_obj));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Obj17Activity.super.onBackPressed();
            }
        });

        ImageView imageOf17Obj1 = findViewById(R.id.imageOf17Obj1Id);
        TextView legendImage117Obj = findViewById(R.id.legendImage117ObjId);
        ImageView imageOf17Obj2 = findViewById(R.id.imageOf17Obj2Id);
        TextView legendImage217Obj = findViewById(R.id.legendImage217ObjId);
        TextView textNewspt = findViewById(R.id.textNoticiasId);
        TextView textLinkDocument = findViewById(R.id.textLinkDocumentId);
        ImageView imageDuvidas = findViewById(R.id.imageDuvidasId);
        TextView textLinkDuvidas = findViewById(R.id.textLinkDuvidasId);
        TextView textLinkDados = findViewById(R.id.textLinkDadosId);
        TextView textLinkSaiba = findViewById(R.id.textLinkSaibaId);
        TextView textLinkAcomp = findViewById(R.id.textLinkAcompId);
        TextView textLinkPageEsp = findViewById(R.id.textLinkPageEspId);
        TextView textLinkDocsTema = findViewById(R.id.textLinkDocsTemaId);
        TextView textLinkTempReal = findViewById(R.id.textLinkTempRealId);
        TextView textLinkAgendPt = findViewById(R.id.textLinkAgendPtId);
        TextView textLinkAgendIng = findViewById(R.id.textLinkAgendIngId);
        TextView textLinkInicadores = findViewById(R.id.textLinkInicadoresId);


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

        ImageView videoYouTube = findViewById(R.id.videoOqueSaoId);
        videoYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startUrl(getResources().getString(R.string.link_video_o_que_sao));
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
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
}
