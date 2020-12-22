package com.luizmagno.os17ods.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.luizmagno.os17ods.fragments.ImgOdsFragment;

import java.util.ArrayList;

public class PagerImgOdsAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Integer> listIdsImgsOds;

    public PagerImgOdsAdapter(@NonNull FragmentManager fm, int behavior,
                              ArrayList<Integer> list) {
        super(fm, behavior);

        this.listIdsImgsOds = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int idImgOds = listIdsImgsOds.get(position);

        Fragment fragment = ImgOdsFragment.newInstance();

        Bundle bundle = new Bundle();

        bundle.putInt("idImgOds", idImgOds);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return listIdsImgsOds.size();
    }
}
