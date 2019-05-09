package com.example.alumno.primerparcialrodrigobalabasquer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHoleder> {
        List<Producto> productos;
        private IMyOnClick listener;
        private Handler myHanler;
        public MyAdapter(List<Producto> productos,IMyOnClick listener,Handler myHanler){
            this.productos =productos;
            this.listener = listener;
            this.myHanler = myHanler;
        }

        @Override
        public MyViewHoleder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v =null;
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy,parent,false);
            MyViewHoleder myViewHoleder = new MyViewHoleder(v,listener);
            return myViewHoleder;
        }

        @Override
        public void onBindViewHolder(MyViewHoleder holder, int position) {

            Producto i = this.productos.get(position);

            holder.tvPrecio.setText(i.getPrecio());
            holder.tvNombre.setText(i.getNombre());
            holder.tvCantidad.setText((i.getCantidad().toString()+ "     "));

            holder.setPosition(position);
        }

        @Override
        public int getItemCount() {

            return this.productos.size();
        }

        public List<Producto> setProductos(List<Producto> p){
            this.productos = p;
            return  p;
        }
}
