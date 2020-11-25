package com.itats.utsmobileriyadi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewProcessHolder> {

    Context context;
    private ArrayList<ModelData> item;

    public Adapter(Context context, ArrayList<ModelData> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public ViewProcessHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewProcessHolder processHolder = new ViewProcessHolder(view);
        return processHolder;
    }

    @Override
    public void onBindViewHolder(ViewProcessHolder holder, int position) {

        final ModelData data = item.get(position);
        holder.nama_data.setText(data.getNamaProduk());
        holder.harga_data.setText(data.getHargaProduk());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewProcessHolder extends RecyclerView.ViewHolder {

        TextView nama_data, harga_data;
        ImageView gambar_data;

        public ViewProcessHolder(View itemView) {
            super(itemView);

            nama_data = (TextView) itemView.findViewById(R.id.text_nama_produk);
            harga_data = (TextView) itemView.findViewById(R.id.text_harga_produk);
            gambar_data = (ImageView) itemView.findViewById(R.id.image_product);
        }
    }
}
