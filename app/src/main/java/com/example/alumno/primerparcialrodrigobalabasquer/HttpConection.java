package com.example.alumno.primerparcialrodrigobalabasquer;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by alumno on 09/05/2019.
 */

public class HttpConection {
    private String metodo;

    public HttpConection(String metodo) {
        this.metodo = metodo;
    }

    public String getStringData(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod(this.metodo);
        if (this.metodo == "GET"){
            urlConnection.connect();
        }
        int response = urlConnection.getResponseCode();
        Log.d("http", "Response code:" + response);
        if(response==200) {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            is.close();
            return new String( baos.toByteArray(),"UTF-8");
        }
        else
            throw new IOException();
    }
}
