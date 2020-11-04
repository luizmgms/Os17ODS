package com.luizmagno.os17ods;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        int idStringShareOds = 0;

        if (bundle != null) {
            numOds = bundle.getInt("numOds");
            idImageOds = bundle.getInt("idImageOds");
            idStringSubtitleOds = bundle.getInt("idStringSubtitleOds");
            idStringDescOds = bundle.getInt("idStringDescOds");
            idColorOds = bundle.getInt("idColorOds");
            idStringShareOds = bundle.getInt("idStringShareOds");
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
        FloatingActionButton fabShare = fragment.findViewById(R.id.fabShareId);

        collapseImage.setImageDrawable(getResources().getDrawable(idImageOds));
        subTitleOfOds.setText(idStringSubtitleOds);
        descOfOds.setText(idStringDescOds);
        int color = ContextCompat.getColor(odsActivity, idColorOds);
        appBarLayout.setBackgroundColor(color);
        containerTitleOfOds.setBackgroundColor(color);
        collapsingToolbarLayout.setContentScrimColor(color);
        final String textOfShared = Objects.requireNonNull(
                getActivity()).getResources().getString(idStringShareOds);
        fabShare.setBackgroundTintList(ColorStateList.valueOf(color));

        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(textOfShared);
            }
        });



        return fragment;
    }

    private void share(String textOfShared) {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textOfShared);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, "Compartilhar com...");
        startActivity(shareIntent);

    }
}
