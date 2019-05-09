package com.example.alumno.primerparcialrodrigobalabasquer;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewHoleder extends RecyclerView.ViewHolder implements  View.OnClickListener {

    public IMyOnClick listener;
    public ImageView viewImagenPlus;
    public ImageView viewImagenMenus;
    public TextView tvNombre;
    public TextView tvPrecio;
    public TextView tvCantidad;
    private int position;

    public MyViewHoleder(View v, IMyOnClick listener) {
        super(v);
        //v.setOnClickListener(this);
        tvCantidad = (TextView) v.findViewById(R.id.tvCantidad);
        tvNombre = (TextView) v.findViewById(R.id.tvNombre);
        tvPrecio = (TextView) v.findViewById(R.id.tvPrecio);
        viewImagenMenus = (ImageView) v.findViewById(R.id.viewImagenMinus);
        viewImagenPlus = (ImageView) v.findViewById(R.id.viewImagenPlus);
        viewImagenPlus.setOnClickListener(this);
        viewImagenMenus.setOnClickListener(this);
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        listener.onItemClick(v,position);
    }
    public void setPosition(int position)
    {
        this.position = position;
    }
}
