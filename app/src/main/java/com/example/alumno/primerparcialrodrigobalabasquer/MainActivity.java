package com.example.alumno.primerparcialrodrigobalabasquer;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMyOnClick, Handler.Callback {
    MyAdapter adapter;
    List<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos = new ArrayList<>();

        RecyclerView rvProductos = (RecyclerView) super.findViewById(R.id.rvProductos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvProductos.setLayoutManager(layoutManager);

        Handler handler = new Handler(this);

        adapter = new MyAdapter(productos,this,handler);
        rvProductos.setAdapter(adapter);

        MyThread hilo = new MyThread(handler,"http://192.168.2.166:8080/Productos.xml",0);
        hilo.start();
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.arg1 == 1){
        this.productos = this.adapter.setProductos((List<Producto>) msg.obj);
        adapter.notifyDataSetChanged();
        }
        return false;
    }

    @Override
    public void onItemClick(View v,int position) {
        Producto p = productos.get(position);
        if(v.getId() == R.id.viewImagenMinus){
            Log.d("Menos", p.getNombre() + " Precio: "+ p.getPrecio() + " Stock: "+ p.getCantidad());
            if(p.getCantidad() > 0){
                p.menosCantidad();
                adapter.notifyItemChanged(position);
            }
        }
        if(v.getId() == R.id.viewImagenPlus){
            Log.d("Mas", p.getNombre() + " Precio: "+ p.getPrecio() + " Stock: "+ p.getCantidad());
                p.masCantidad();
                adapter.notifyItemChanged(position);
        }
    }
}
