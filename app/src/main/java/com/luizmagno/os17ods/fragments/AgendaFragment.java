package com.luizmagno.os17ods.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luizmagno.os17ods.R;

public class AgendaFragment extends Fragment {

    View docsView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        docsView = inflater.inflate(R.layout.layout_agenda, container, false);
        return docsView;
    }
}