package com.luizmagno.os17ods.adapters;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luizmagno.os17ods.MainActivity;
import com.luizmagno.os17ods.R;
import com.luizmagno.os17ods.activities.OdsActivity;

import java.util.ArrayList;

public class OdsAdapter extends RecyclerView.Adapter<OdsAdapter.ItemOdsViewHolder> {

    private final ArrayList<Integer> listIdsOds;
    private final MainActivity mainActivity;

    public OdsAdapter(MainActivity mActivity, ArrayList<Integer> list) {
        this.mainActivity = mActivity;
        this.listIdsOds = list;
    }

    //Inner Class
    public static class ItemOdsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageOds;
        public ItemOdsViewHolder(View view) {
            super(view);
            imageOds = view.findViewById(R.id.imageOdsId);
        }
    }

    @NonNull
    @Override
    public ItemOdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_ods, parent, false);

        return new ItemOdsViewHolder(itemView);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ItemOdsViewHolder holder, final int position) {
        final int id = listIdsOds.get(position);
        holder.imageOds.setImageResource(id);
        holder.imageOds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startOdsActivity(position);
            }
        });
        holder.imageOds.setOnTouchListener(onTouchListener());
    }

    @Override
    public int getItemCount() {
        return listIdsOds.size();
    }

    public void startOdsActivity(int pos) {
        Intent i = new Intent(mainActivity, OdsActivity.class);
        i.putExtra("pos", pos);
        mainActivity.startActivity(i, ActivityOptions
                .makeSceneTransitionAnimation(mainActivity).toBundle());
    }

    private View.OnTouchListener onTouchListener() {
        return (new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        //clear the overlay
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }

                return false;
            }
        });
    }

}