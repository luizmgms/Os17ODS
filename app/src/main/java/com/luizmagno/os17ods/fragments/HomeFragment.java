package com.luizmagno.os17ods.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.luizmagno.os17ods.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View homeView;
    private ArrayList<View> objectives;
    public FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.layout_home, container, false);

        objectives = new ArrayList<>();

        //Preenchendo Array de Objetivos - 0 a 17
        fillListOfObjectives();

        //Pegando largura do Objetivo em pixels
        int side = getSideOfObjective();

        //Setando altura, largura e click dos constraintsLayouts
        setWidthAndHeightOfObjectives(side);

        return homeView;
    }

    private void fillListOfObjectives() {
        objectives.add( homeView.findViewById(R.id.imageOds1Id) );
        objectives.add( homeView.findViewById(R.id.imageOds2Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds3Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds4Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds5Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds6Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds7Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds8Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds9Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds10Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds11Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds12Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds13Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds14Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds15Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds16Id) );
        objectives.add(  homeView.findViewById(R.id.imageOds17Id) );
        objectives.add(  homeView.findViewById(R.id.imageONUId) );

    }

    private int getSideOfObjective() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        return width/2;
    }

    private void setWidthAndHeightOfObjectives(int side) {
        for (View objective: objectives) {
            objective.getLayoutParams().width = side;
            objective.getLayoutParams().height = side;
            objective.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        v.setAlpha(0.6f);
        String numOfOds = getNumOds(v);
        Fragment ods_frag = new OdsFragment();
        Bundle bund = new Bundle();
        bund.putString("idOds", numOfOds);
        ods_frag.setArguments(bund);

        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_fragment, ods_frag)
                .addToBackStack(null)
                .commit();

    }

    private String getNumOds(@NotNull View v){
        String numOds;
        switch (v.getId()) {
            case R.id.imageOds1Id:
                numOds = "1";
                break;
            case R.id.imageOds2Id:
                numOds = "2";
                break;
            case R.id.imageOds3Id:
                numOds = "3";
                break;
            case R.id.imageOds4Id:
                numOds = "4";
                break;
            case R.id.imageOds5Id:
                numOds = "5";
                break;
            case R.id.imageOds6Id:
                numOds = "6";
                break;
            case R.id.imageOds7Id:
                numOds = "7";
                break;
            case R.id.imageOds8Id:
                numOds = "8";
                break;
            case R.id.imageOds9Id:
                numOds = "9";
                break;
            case R.id.imageOds10Id:
                numOds = "10";
                break;
            case R.id.imageOds11Id:
                numOds = "11";
                break;
            case R.id.imageOds12Id:
                numOds = "12";
                break;
            case R.id.imageOds13Id:
                numOds = "13";
                break;
            case R.id.imageOds14Id:
                numOds = "14";
                break;
            case R.id.imageOds15Id:
                numOds = "15";
                break;
            case R.id.imageOds16Id:
                numOds = "16";
                break;
            case R.id.imageOds17Id:
                numOds = "17";
                break;
            default:
                numOds = "0";
                break;
        }

        return numOds;

    }
}
