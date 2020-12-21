package com.luizmagno.os17ods.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.luizmagno.os17ods.R;
import com.luizmagno.os17ods.activities.OdsActivity;
import com.luizmagno.os17ods.activities.ViewImageActivity;

import java.util.List;
import java.util.Objects;

public class OdsFragment extends Fragment {

    OdsActivity odsActivity;

    public OdsFragment(OdsActivity odsActivity) {
        this.odsActivity = odsActivity;
    }

    public static OdsFragment newInstance(OdsActivity activity) {
        return new OdsFragment(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View fragment = inflater.inflate(R.layout.layout_ods, container, false);

        Bundle bundle = getArguments();
        int numOds = 0;
        int idImageOds = 0;
        int idStringSubtitleOds = 0;
        int idStringDescOds = 0;
        int idColorOds = 0;

        if (bundle != null) {
            numOds = bundle.getInt("numOds");
            idImageOds = bundle.getInt("idImageOds");
            idStringSubtitleOds = bundle.getInt("idStringSubtitleOds");
            idStringDescOds = bundle.getInt("idStringDescOds");
            idColorOds = bundle.getInt("idColorOds");
        }


        Toolbar toolbar = fragment.findViewById(R.id.toolbarInOdsId);
        odsActivity.setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odsActivity.onBackPressed();
            }
        });

        //Set Titulo da toolbar
        if(numOds == 0) {
            toolbar.setTitle(R.string.app_name);
        } else {
            toolbar.setTitle("Objetivo Nº " + numOds);
        }

        //Atributos
        AppBarLayout appBarLayout = fragment.findViewById(R.id.barLayoutInOdsId);
        CollapsingToolbarLayout collapsingToolbarLayout =
                fragment.findViewById(R.id.collapseTbLayoutId);
        View containerTitleOfOds = fragment.findViewById(R.id.backgroundTitleId);
        TextView subTitleOfOds = fragment.findViewById(R.id.subTitleOdOdsId);
        TextView descOfOds = fragment.findViewById(R.id.descOfOdsId);
        ImageView collapseImage = fragment.findViewById(R.id.imageCollapseInOdsId);

        collapseImage.setImageResource(idImageOds);
        subTitleOfOds.setText(idStringSubtitleOds);
        descOfOds.setText(idStringDescOds);
        int color = ContextCompat.getColor(odsActivity, idColorOds);
        appBarLayout.setBackgroundColor(color);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        containerTitleOfOds.setBackgroundColor(color);
        collapsingToolbarLayout.setContentScrimColor(color);

        final int id = idImageOds;
        collapseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImage(id);
            }
        });

        return fragment;
    }

    private void openImage(int id){
        Intent intent = new Intent(getActivity(), ViewImageActivity.class);
        intent.putExtra("idImage", id);
        startActivity(intent);

    }

}
