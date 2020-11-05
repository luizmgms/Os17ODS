package com.luizmagno.os17ods.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
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
    }

    @Override
    public int getItemCount() {
        return listIdsOds.size();
    }

    public void startOdsActivity(int pos) {
        Intent i = new Intent(mainActivity, OdsActivity.class);
        i.putExtra("pos", pos);
        mainActivity.startActivity(i);
    }

}