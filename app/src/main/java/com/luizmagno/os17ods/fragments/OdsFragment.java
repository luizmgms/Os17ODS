package com.luizmagno.os17ods.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.luizmagno.os17ods.R;

public class OdsFragment extends Fragment {
    private View odsView;
    private View containerTitleOfOds;
    private TextView numOfOds;
    private TextView titleOfOds;
    private TextView subTitleOfOds;
    private TextView descOfOds;
    private Toolbar tb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        odsView = inflater.inflate(R.layout.layout_ods, container, false);

        containerTitleOfOds = odsView.findViewById(R.id.backgroundTitleId);
        numOfOds = odsView.findViewById(R.id.numOdsId);
        titleOfOds = odsView.findViewById(R.id.titleOdsId);
        subTitleOfOds = odsView.findViewById(R.id.subTitleOdOdsId);
        descOfOds = odsView.findViewById(R.id.descOfOdsId);
        tb = getActivity().findViewById(R.id.toolbar);

        //Pegando número da Ods
        Bundle extras = this.getArguments();
        String num_ods = extras.getString("idOds");

        //Set Titulo da toolbar
        if(!num_ods.equals("0")) {
            tb.setTitle("Objetivo "+num_ods);
        } else {
            tb.setTitle(R.string.app_name);
        }


        //Set TextView com Número da Ods
        numOfOds.setText(num_ods);

        //Setando Views
        setAttributesOfOds(num_ods);

        return odsView;
    }

    //Setando atributos de acordo com o número da ODS
    private void setAttributesOfOds(String idOfOds) {

        int color;

        switch (idOfOds) {
            case "1":
                titleOfOds.setText(R.string.ods1_title);
                subTitleOfOds.setText(R.string.ods1_subtitle);
                descOfOds.setText(R.string.ods1_desc);
                color = ContextCompat.getColor(getContext(), R.color.colorOfOds1);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "2":
                titleOfOds.setText(R.string.ods2_title);
                subTitleOfOds.setText(R.string.ods2_subtitle);
                descOfOds.setText(R.string.ods2_desc);
                color = ContextCompat.getColor(getContext(), R.color.colorOfOds2);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "3":
                titleOfOds.setText(R.string.ods3_title);
                subTitleOfOds.setText(R.string.ods3_subtitle);
                descOfOds.setText(R.string.ods3_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds3);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "4":
                titleOfOds.setText(R.string.ods4_title);
                subTitleOfOds.setText(R.string.ods4_subtitle);
                descOfOds.setText(R.string.ods4_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds4);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "5":
                titleOfOds.setText(R.string.ods5_title);
                subTitleOfOds.setText(R.string.ods5_subtitle);
                descOfOds.setText(R.string.ods5_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds5);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "6":
                titleOfOds.setText(R.string.ods6_title);
                subTitleOfOds.setText(R.string.ods6_subtitle);
                descOfOds.setText(R.string.ods6_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds6);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "7":
                titleOfOds.setText(R.string.ods7_title);
                subTitleOfOds.setText(R.string.ods7_subtitle);
                descOfOds.setText(R.string.ods7_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds7);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "8":
                titleOfOds.setText(R.string.ods8_title);
                subTitleOfOds.setText(R.string.ods8_subtitle);
                descOfOds.setText(R.string.ods8_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds8);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "9":
                titleOfOds.setText(R.string.ods9_title);
                subTitleOfOds.setText(R.string.ods9_subtitle);
                descOfOds.setText(R.string.ods9_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds9);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "10":
                titleOfOds.setText(R.string.ods10_title);
                subTitleOfOds.setText(R.string.ods10_subtitle);
                descOfOds.setText(R.string.ods10_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds10);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "11":
                titleOfOds.setText(R.string.ods11_title);
                subTitleOfOds.setText(R.string.ods11_subtitle);
                descOfOds.setText(R.string.ods11_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds11);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "12":
                titleOfOds.setText(R.string.ods12_title);
                subTitleOfOds.setText(R.string.ods12_subtitle);
                descOfOds.setText(R.string.ods12_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds12);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "13":
                titleOfOds.setText(R.string.ods13_title);
                subTitleOfOds.setText(R.string.ods13_subtitle);
                descOfOds.setText(R.string.ods13_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds13);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "14":
                titleOfOds.setText(R.string.ods14_title);
                subTitleOfOds.setText(R.string.ods14_subtitle);
                descOfOds.setText(R.string.ods14_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds14);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "15":
                titleOfOds.setText(R.string.ods15_title);
                subTitleOfOds.setText(R.string.ods15_subtitle);
                descOfOds.setText(R.string.ods15_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds15);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "16":
                titleOfOds.setText(R.string.ods16_title);
                subTitleOfOds.setText(R.string.ods16_subtitle);
                descOfOds.setText(R.string.ods16_desc);
                color = ContextCompat.getColor(getContext(),R.color.colorOfOds16);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            case "17":
                titleOfOds.setText(R.string.ods17_title);
                subTitleOfOds.setText(R.string.ods17_subtitle);
                descOfOds.setText(R.string.ods17_desc);
                color = ContextCompat.getColor(getContext(), R.color.colorOfOds17);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                break;
            default:
                titleOfOds.setText(R.string.ods_onu_title);
                subTitleOfOds.setText(R.string.ods_onu_subtitle);
                descOfOds.setText(R.string.ods_onu_desc_full);
                color = ContextCompat.getColor(getContext(), R.color.colorOfOdsONU);
                containerTitleOfOds.setBackgroundColor(color);
                tb.setBackgroundColor(color);
                numOfOds.setText("");
                break;
        }

    }
}
