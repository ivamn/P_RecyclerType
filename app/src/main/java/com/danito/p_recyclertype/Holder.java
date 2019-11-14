package com.danito.p_recyclertype;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView, imageView1, imageView2, imageView3;
    Button bShare, bExplore;
    TextView textView, textViewL;
    private View.OnClickListener imageClickListener;

    public Holder(View v) {
        super(v);
        switch (v.getId()) {
            case R.id.cadview1:
                break;
            case R.id.cadview2:
                imageView1 = v.findViewById(R.id.imageView1);
                imageView1.setOnClickListener(this);
                imageView2 = v.findViewById(R.id.imageView2);
                imageView2.setOnClickListener(this);
                imageView3 = v.findViewById(R.id.imageView3);
                imageView3.setOnClickListener(this);
                break;
            case R.id.cadview3:
                bShare = v.findViewById(R.id.bShare);
                bShare.setOnClickListener(this);
                bExplore = v.findViewById(R.id.bExplore);
                bExplore.setOnClickListener(this);
                textViewL = v.findViewById(R.id.textViewL);
                break;
        }
        textView = v.findViewById(R.id.txt_title);
        imageView = v.findViewById(R.id.imageView);
    }

    public void bind(Dato dato) {
        switch (dato.getTipo()) {
            case MainActivity.TYPE_ITEM_1:
                imageView.setImageBitmap(dato.getFoto());
                textView.setText(dato.getTextoCorto());
                break;
            case MainActivity.TYPE_ITEM_2:
                imageView.setImageBitmap(dato.getFoto());
                textView.setText(dato.getTextoCorto());
                break;
            case MainActivity.TYPE_ITEM_3:
                imageView.setImageBitmap(dato.getFoto());
                textView.setText(dato.getTextoCorto());
                textViewL.setText(dato.getTextoLargo());
                break;
        }
    }

    public void setImageClickListener(View.OnClickListener listener) {
        if (listener != null) {
            imageClickListener = listener;
        }
    }

    @Override
    public void onClick(View v) {
        if (imageClickListener != null) {
            imageClickListener.onClick(v);
        }
    }
}
