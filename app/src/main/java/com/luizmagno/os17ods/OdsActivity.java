package com.luizmagno.os17ods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class OdsActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private ImageView collapseImage;
    private View containerTitleOfOds;
    private TextView subTitleOfOds;
    private TextView descOfOds;
    private String textOfShared;

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

        //Setando Views
        setAttributesOfOds(num_ods);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ods, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shared) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, textOfShared);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);

        }

        return super.onOptionsItemSelected(item);
    }

    //Setando atributos de acordo com o número da ODS
    private void setAttributesOfOds(String idOfOds) {

        int color;

        switch (idOfOds) {
            case "1":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_1));
                subTitleOfOds.setText(R.string.ods1_subtitle);
                descOfOds.setText(R.string.ods1_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds1);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods1);
                break;
            case "2":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_2));
                subTitleOfOds.setText(R.string.ods2_subtitle);
                descOfOds.setText(R.string.ods2_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds2);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods2);
                break;
            case "3":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_3));
                subTitleOfOds.setText(R.string.ods3_subtitle);
                descOfOds.setText(R.string.ods3_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds3);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods3);
                break;
            case "4":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_4));
                subTitleOfOds.setText(R.string.ods4_subtitle);
                descOfOds.setText(R.string.ods4_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds4);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods4);
                break;
            case "5":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_5));
                subTitleOfOds.setText(R.string.ods5_subtitle);
                descOfOds.setText(R.string.ods5_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds5);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods5);
                break;
            case "6":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_6));
                subTitleOfOds.setText(R.string.ods6_subtitle);
                descOfOds.setText(R.string.ods6_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds6);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods6);
                break;
            case "7":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_7));
                subTitleOfOds.setText(R.string.ods7_subtitle);
                descOfOds.setText(R.string.ods7_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds7);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods7);
                break;
            case "8":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_8));
                subTitleOfOds.setText(R.string.ods8_subtitle);
                descOfOds.setText(R.string.ods8_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds8);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods8);
                break;
            case "9":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_9));
                subTitleOfOds.setText(R.string.ods9_subtitle);
                descOfOds.setText(R.string.ods9_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds9);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods9);
                break;
            case "10":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_10));
                subTitleOfOds.setText(R.string.ods10_subtitle);
                descOfOds.setText(R.string.ods10_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds10);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods10);
                break;
            case "11":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_11));
                subTitleOfOds.setText(R.string.ods11_subtitle);
                descOfOds.setText(R.string.ods11_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds11);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods11);
                break;
            case "12":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_12));
                subTitleOfOds.setText(R.string.ods12_subtitle);
                descOfOds.setText(R.string.ods12_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds12);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods12);
                break;
            case "13":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_13));
                subTitleOfOds.setText(R.string.ods13_subtitle);
                descOfOds.setText(R.string.ods13_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds13);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods13);
                break;
            case "14":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_14));
                subTitleOfOds.setText(R.string.ods14_subtitle);
                descOfOds.setText(R.string.ods14_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds14);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods14);
                break;
            case "15":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_15));
                subTitleOfOds.setText(R.string.ods15_subtitle);
                descOfOds.setText(R.string.ods15_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds15);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods15);
                break;
            case "16":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_16));
                subTitleOfOds.setText(R.string.ods16_subtitle);
                descOfOds.setText(R.string.ods16_desc);
                color = ContextCompat.getColor(this,R.color.colorOfOds16);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods16);
                break;
            case "17":
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_17));
                subTitleOfOds.setText(R.string.ods17_subtitle);
                descOfOds.setText(R.string.ods17_desc);
                color = ContextCompat.getColor(this, R.color.colorOfOds17);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods17);
                break;
            default:
                collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_onu));
                subTitleOfOds.setText(R.string.ods_onu_subtitle);
                descOfOds.setText(R.string.ods_onu_desc_full);
                color = ContextCompat.getColor(this, R.color.colorOfOdsONU);
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods_onu);
                break;
        }

    }
}
