package com.example.sqlite1_museo_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite1_museo_recyclerview.Pintura;
import com.example.sqlite1_museo_recyclerview.R;

import java.util.List;

public class PinturaAdapter extends RecyclerView.Adapter<PinturaAdapter.PinturaViewHolder> {
    private List<Pintura> pinturas;

    public PinturaAdapter(List<Pintura> pinturas) {
        this.pinturas = pinturas;
    }

    @NonNull
    @Override
    public PinturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pintura, parent, false);
        return new PinturaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PinturaViewHolder holder, int position) {
        Pintura pintura = pinturas.get(position);
        holder.textViewTitulo.setText(pintura.getTitulo());
        holder.textViewAutorAnio.setText(pintura.getAutor() + ", " + pintura.getAnio());
    }

    @Override
    public int getItemCount() {
        return pinturas.size();
    }

    public static class PinturaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitulo;
        TextView textViewAutorAnio;

        public PinturaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewAutorAnio = itemView.findViewById(R.id.textViewAutorAnio);
        }
    }
}
