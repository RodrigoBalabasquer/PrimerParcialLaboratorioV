package com.example.alumno.primerparcialrodrigobalabasquer;

/**
 * Created by alumno on 09/05/2019.
 */

public class Producto {
    private String nombre;
    private Integer cantidad;
    private String precio;
    public Producto(){

    }
    public Producto(String nombre,int cantidad,String precio){
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void masCantidad(){
        this.cantidad = this.cantidad + 1;
    }
    public void menosCantidad(){
        this.cantidad = this.cantidad - 1;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
