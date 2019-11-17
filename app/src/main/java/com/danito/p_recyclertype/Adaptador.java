package com.danito.p_recyclertype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener{
    Context context;
    View.OnClickListener clickListener;
    View.OnLongClickListener longClickListener;
    View.OnClickListener imageClickListener;

    public Adaptador(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return ((MainActivity)context).datos.get(position).getTipo();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        switch (viewType) {
            case MainActivity.TYPE_ITEM_1:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1, parent, false);
                break;
            case MainActivity.TYPE_ITEM_2:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2, parent, false);
                break;
            case MainActivity.TYPE_ITEM_3:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_3, parent, false);
                break;
        }
        Holder holder = new Holder(v);
        holder.setImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageClickListener != null) {
                    imageClickListener.onClick(v);
                }
            }
        });
        v.setOnClickListener(clickListener);
        v.setOnLongClickListener(longClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).bind(((MainActivity) context).datos.get(position));
    }

    @Override
    public int getItemCount() {
        return ((MainActivity) context).datos.size();
    }

    public void setImageClickListener(View.OnClickListener listener) {
        if (listener != null) {
            imageClickListener = listener;
        }
    }

    public void setClickListener(View.OnClickListener listener) {
        if (listener != null){
            clickListener = listener;
        }
    }

    @Override
    public void onClick(View v) {
        if (clickListener != null) {
            clickListener.onClick(v);
        }
    }

    public void setLongClickListener(View.OnLongClickListener listener) {
        if (listener != null) {
            longClickListener = listener;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (longClickListener != null) {
            longClickListener.onLongClick(v);
        }
        return false;
    }
}
