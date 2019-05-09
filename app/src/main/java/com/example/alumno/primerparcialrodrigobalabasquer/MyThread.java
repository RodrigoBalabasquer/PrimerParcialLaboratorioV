package com.example.alumno.primerparcialrodrigobalabasquer;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

public class MyThread extends  Thread {
    Handler handler;
    String url;
    int position;
    public MyThread(Handler handler,String url, int position){
        this.handler = handler;
        this.url = url;
        this.position =position;
    }
    @Override
    public void run(){
        HttpConection http = new HttpConection("GET");
        Message m = new Message();
        m.arg1 = 1;
        m.arg2 = position;
        try {
            String s = http.getStringData(url);
            m.obj = XmlParser.obtenerProductos(s);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

        this.handler.sendMessage(m);
    }
}
