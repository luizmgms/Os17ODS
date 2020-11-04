package com.luizmagno.os17ods;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerOdsAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Integer> listNumOds;
    private final OdsActivity odsActivity;

    public ViewPagerOdsAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Integer> list, OdsActivity odsActivity) {
        super(fm, behavior);

        this.listNumOds = list;
        this.odsActivity = odsActivity;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        int numOds = listNumOds.get(position);
        Fragment fragment = OdsFragment.newInstance(odsActivity);
        Bundle bundle = new Bundle();

        int [] ids = getIdsOfAttribOds(numOds);

        bundle.putInt("numOds", numOds);
        bundle.putInt("idImageOds", ids[0]);
        bundle.putInt("idStringSubtitleOds",ids[1]);
        bundle.putInt("idStringDescOds", ids[2]);
        bundle.putInt("idColorOds", ids[3]);
        bundle.putInt("idStringShareOds", ids[4]);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return listNumOds.size();
    }

    private int[] getIdsOfAttribOds(int num) {
        int[] ids = {0, 0, 0, 0, 0};

        switch (num) {
            case 0:
                ids[0] = R.drawable.ods_onu;
                ids[1] = R.string.ods_onu_subtitle;
                ids[2] = R.string.ods_onu_desc_full;
                ids[3] = R.color.colorOfOdsONU;
                ids[4] = R.string.text_share_ods_onu;
                break;
            case 1:
                ids[0] = R.drawable.ods_1;
                ids[1] = R.string.ods1_subtitle;
                ids[2] = R.string.ods1_desc;
                ids[3] = R.color.colorOfOds1;
                ids[4] = R.string.text_share_ods1;
                break;
            case 2:
                ids[0] = R.drawable.ods_2;
                ids[1] = R.string.ods2_subtitle;
                ids[2] = R.string.ods2_desc;
                ids[3] = R.color.colorOfOds2;
                ids[4] = R.string.text_share_ods2;
                break;
            case 3:
                ids[0] = R.drawable.ods_3;
                ids[1] = R.string.ods3_subtitle;
                ids[2] = R.string.ods3_desc;
                ids[3] = R.color.colorOfOds3;
                ids[4] = R.string.text_share_ods3;
                break;
            case 4:
                ids[0] = R.drawable.ods_4;
                ids[1] = R.string.ods4_subtitle;
                ids[2] = R.string.ods4_desc;
                ids[3] = R.color.colorOfOds4;
                ids[4] = R.string.text_share_ods4;
                break;
            case 5:
                ids[0] = R.drawable.ods_5;
                ids[1] = R.string.ods5_subtitle;
                ids[2] = R.string.ods5_desc;
                ids[3] = R.color.colorOfOds5;
                ids[4] = R.string.text_share_ods5;
                break;
            case 6:
                ids[0] = R.drawable.ods_6;
                ids[1] = R.string.ods6_subtitle;
                ids[2] = R.string.ods6_desc;
                ids[3] = R.color.colorOfOds6;
                ids[4] = R.string.text_share_ods6;
                break;
            case 7:
                ids[0] = R.drawable.ods_7;
                ids[1] = R.string.ods7_subtitle;
                ids[2] = R.string.ods7_desc;
                ids[3] = R.color.colorOfOds7;
                ids[4] = R.string.text_share_ods7;
                break;
            case 8:
                ids[0] = R.drawable.ods_8;
                ids[1] = R.string.ods8_subtitle;
                ids[2] = R.string.ods8_desc;
                ids[3] = R.color.colorOfOds8;
                ids[4] = R.string.text_share_ods8;
                break;
            case 9:
                ids[0] = R.drawable.ods_9;
                ids[1] = R.string.ods9_subtitle;
                ids[2] = R.string.ods9_desc;
                ids[3] = R.color.colorOfOds9;
                ids[4] = R.string.text_share_ods9;
                break;
            case 10:
                ids[0] = R.drawable.ods_10;
                ids[1] = R.string.ods10_subtitle;
                ids[2] = R.string.ods10_desc;
                ids[3] = R.color.colorOfOds10;
                ids[4] = R.string.text_share_ods10;
                break;
            case 11:
                ids[0] = R.drawable.ods_11;
                ids[1] = R.string.ods11_subtitle;
                ids[2] = R.string.ods11_desc;
                ids[3] = R.color.colorOfOds11;
                ids[4] = R.string.text_share_ods11;
                break;
            case 12:
                ids[0] = R.drawable.ods_12;
                ids[1] = R.string.ods12_subtitle;
                ids[2] = R.string.ods12_desc;
                ids[3] = R.color.colorOfOds12;
                ids[4] = R.string.text_share_ods12;
                break;
            case 13:
                ids[0] = R.drawable.ods_13;
                ids[1] = R.string.ods13_subtitle;
                ids[2] = R.string.ods13_desc;
                ids[3] = R.color.colorOfOds13;
                ids[4] = R.string.text_share_ods13;
                break;
            case 14:
                ids[0] = R.drawable.ods_14;
                ids[1] = R.string.ods14_subtitle;
                ids[2] = R.string.ods14_desc;
                ids[3] = R.color.colorOfOds14;
                ids[4] = R.string.text_share_ods14;
                break;
            case 15:
                ids[0] = R.drawable.ods_15;
                ids[1] = R.string.ods15_subtitle;
                ids[2] = R.string.ods15_desc;
                ids[3] = R.color.colorOfOds15;
                ids[4] = R.string.text_share_ods15;
                break;
            case 16:
                ids[0] = R.drawable.ods_16;
                ids[1] = R.string.ods16_subtitle;
                ids[2] = R.string.ods16_desc;
                ids[3] = R.color.colorOfOds16;
                ids[4] = R.string.text_share_ods16;
                break;
            case 17:
                ids[0] = R.drawable.ods_17;
                ids[1] = R.string.ods17_subtitle;
                ids[2] = R.string.ods17_desc;
                ids[3] = R.color.colorOfOds17;
                ids[4] = R.string.text_share_ods17;
                break;
            default:
                /*collapseImage.setImageDrawable(getResources().getDrawable(R.drawable.ods_onu));
                subTitleOfOds.setText(R.string.ods_onu_subtitle);
                descOfOds.setText(R.string.ods_onu_desc_full);
                color = ContextCompat.getColor(this, R.color.colorOfOdsONU);
                appBarLayout.setBackgroundColor(getResources().getColor(android.R.color.white));
                containerTitleOfOds.setBackgroundColor(color);
                collapsingToolbarLayout.setContentScrimColor(color);
                textOfShared = getResources().getString(R.string.text_share_ods_onu);*/
                ids[0] = R.drawable.ods_onu;
                ids[1] = R.string.erro;
                ids[2] = R.string.erro;
                ids[3] = R.color.colorOfOdsONU;
                ids[4] = R.string.text_share_ods_onu;
                break;
        }

        return ids;
    }
}
