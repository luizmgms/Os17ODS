package com.luizmagno.os17ods.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.luizmagno.os17ods.activities.OdsActivity;
import com.luizmagno.os17ods.fragments.OdsFragment;

import java.util.ArrayList;

import static com.luizmagno.os17ods.utils.Utilities.getIdsOfAttribOds;

public class ViewPagerOdsAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Integer> listNumOds;
    private final OdsActivity odsActivity;

    public ViewPagerOdsAdapter(@NonNull FragmentManager fm, int behavior,
                               ArrayList<Integer> list, OdsActivity odsActivity) {
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
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return listNumOds.size();
    }


}
