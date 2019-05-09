package com.example.alumno.primerparcialrodrigobalabasquer;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    public static List<Producto> obtenerProductos(String xml){
        List<Producto> lista = new ArrayList<>();
        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            Producto p = null;
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT){
                if (event == XmlPullParser.START_TAG) {
                    if("producto".equals(xmlPullParser.getName()))
                    {
                        p = new Producto();
                    }
                    if("nombre".equals(xmlPullParser.getName())){
                        if(p != null){
                            p.setNombre(xmlPullParser.nextText());
                        }
                    }
                    if("precio".equals(xmlPullParser.getName())){
                        if(p != null){
                            p.setPrecio(xmlPullParser.nextText());
                        }
                    }
                    if("cantidad".equals(xmlPullParser.getName())){
                        if(p != null){
                            p.setCantidad(Integer.parseInt(xmlPullParser.nextText()));
                        }
                    }
                }
                else if(event == XmlPullParser.END_TAG && "producto".equals(xmlPullParser.getName())){
                    lista.add(p);
                }
                event = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
