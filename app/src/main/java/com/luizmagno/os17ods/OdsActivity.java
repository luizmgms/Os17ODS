package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class OdsActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private ImageView collapseImage;
    private View containerTitleOfOds;
    private TextView numOfOds;
    private TextView titleOfOds;
    private TextView subTitleOfOds;
    private TextView descOfOds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ods);

        //set toolbar
        toolbar = findViewById(R.id.toolbarInOdsId);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OdsActivity.super.onBackPressed();
            }
        });

        //Atributos
        collapsingToolbarLayout = findViewById(R.id.collapseTbLayoutId);
        containerTitleOfOds = findViewById(R.id.backgroundTitleId);
        numOfOds = findViewById(R.id.numOdsId);
        titleOfOds = findViewById(R.id.titleOdsId);
        subTitleOfOds = findViewById(R.id.subTitleOdOdsId);
        descOfOds = findViewById(R.id.descOfOdsId);
        collapseImage = findViewById(R.id.imageCollapseInOdsId);

        //Pegando número da Ods
        String num_ods = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null ) {
            num_ods = extras.getString("idOds");
        }

        //Set Titulo da toolbar
        if(!num_ods.equals("0")) {
            toolbar.setTitle("Objetivo "+num_ods);
        } else {
            toolbar.setTitle(R.string.app_name);
        }

        //Set TextView com Número da Ods
        numOfOds.setText(num_ods);

        //Setando Views
        setAttributesOfOds(num_ods);
    }

    //Setando atributos de acordo com o número da ODS
    private void setAttributesOfOds(String idOfOds) {

        int color;

        switch (idOfOds) {
            case "1":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_1));
                titleOfOds.setText(R.string.ods1_title);
                subTitleOfOds.setText(R.string.ods1_subtitle);
                descOfOds.setText(R.string.ods1_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds1);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                //toolbar.setBackgroundColor(color);
                break;
            case "2":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_2));
                titleOfOds.setText(R.string.ods2_title);
                subTitleOfOds.setText(R.string.ods2_subtitle);
                descOfOds.setText(R.string.ods2_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds2);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                //toolbar.setBackgroundColor(color);
                break;
            case "3":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_3));
                titleOfOds.setText(R.string.ods3_title);
                subTitleOfOds.setText(R.string.ods3_subtitle);
                descOfOds.setText(R.string.ods3_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds3);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "4":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_4));
                titleOfOds.setText(R.string.ods4_title);
                subTitleOfOds.setText(R.string.ods4_subtitle);
                descOfOds.setText(R.string.ods4_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds4);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "5":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_5));
                titleOfOds.setText(R.string.ods5_title);
                subTitleOfOds.setText(R.string.ods5_subtitle);
                descOfOds.setText(R.string.ods5_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds5);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "6":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_6));
                titleOfOds.setText(R.string.ods6_title);
                subTitleOfOds.setText(R.string.ods6_subtitle);
                descOfOds.setText(R.string.ods6_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds6);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "7":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_7));
                titleOfOds.setText(R.string.ods7_title);
                subTitleOfOds.setText(R.string.ods7_subtitle);
                descOfOds.setText(R.string.ods7_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds7);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "8":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_8));
                titleOfOds.setText(R.string.ods8_title);
                subTitleOfOds.setText(R.string.ods8_subtitle);
                descOfOds.setText(R.string.ods8_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds8);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "9":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_9));
                titleOfOds.setText(R.string.ods9_title);
                subTitleOfOds.setText(R.string.ods9_subtitle);
                descOfOds.setText(R.string.ods9_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds9);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "10":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_10));
                titleOfOds.setText(R.string.ods10_title);
                subTitleOfOds.setText(R.string.ods10_subtitle);
                descOfOds.setText(R.string.ods10_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds10);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "11":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_11));
                titleOfOds.setText(R.string.ods11_title);
                subTitleOfOds.setText(R.string.ods11_subtitle);
                descOfOds.setText(R.string.ods11_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds11);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "12":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_12));
                titleOfOds.setText(R.string.ods12_title);
                subTitleOfOds.setText(R.string.ods12_subtitle);
                descOfOds.setText(R.string.ods12_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds12);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "13":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_13));
                titleOfOds.setText(R.string.ods13_title);
                subTitleOfOds.setText(R.string.ods13_subtitle);
                descOfOds.setText(R.string.ods13_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds13);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "14":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_14));
                titleOfOds.setText(R.string.ods14_title);
                subTitleOfOds.setText(R.string.ods14_subtitle);
                descOfOds.setText(R.string.ods14_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds14);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "15":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_15));
                titleOfOds.setText(R.string.ods15_title);
                subTitleOfOds.setText(R.string.ods15_subtitle);
                descOfOds.setText(R.string.ods15_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds15);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "16":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_16));
                titleOfOds.setText(R.string.ods16_title);
                subTitleOfOds.setText(R.string.ods16_subtitle);
                descOfOds.setText(R.string.ods16_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds16);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            case "17":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_17));
                titleOfOds.setText(R.string.ods17_title);
                subTitleOfOds.setText(R.string.ods17_subtitle);
                descOfOds.setText(R.string.ods17_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds17);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                break;
            default:
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_onu));
                titleOfOds.setText(R.string.ods_onu_title);
                subTitleOfOds.setText(R.string.ods_onu_subtitle);
                descOfOds.setText(R.string.ods_onu_desc_full);
                color = ContextCompat.getColor(this, R.color.colorOfOdsONU);
                containerTitleOfOds.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                numOfOds.setText("");
                break;
        }

    }
}
