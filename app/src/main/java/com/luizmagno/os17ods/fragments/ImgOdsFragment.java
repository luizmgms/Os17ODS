package com.luizmagno.os17ods.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.chrisbanes.photoview.PhotoView;
import com.luizmagno.os17ods.R;

public class ImgOdsFragment extends Fragment {

    public static ImgOdsFragment newInstance() {
        return new ImgOdsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View fragment = inflater.inflate(
                R.layout.layout_photo_view, container, false);

        Bundle bundle = getArguments();

        int idImgOds = 0;
        if (bundle != null) {
            idImgOds = bundle.getInt("idImgOds");
        }

        PhotoView photoView = fragment.findViewById(R.id.imagePhotoViewId);
        photoView.setImageResource(idImgOds);

        return fragment;
    }
}
