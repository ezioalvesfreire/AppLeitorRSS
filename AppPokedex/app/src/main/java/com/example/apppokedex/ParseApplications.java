package com.example.apppokedex;

import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.util.Log;

import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.lang.reflect.Type;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParseApplications {
    private static final String TAG = "ParseApplications";

    private ArrayList<FeedEntry> applications;

    public ParseApplications() {
        applications = new ArrayList<>();
    }


    //metodo get "getApplications(){}" para acessar os dados do array "ArrayList<FeedEntry>applications" externamente
    public ArrayList<FeedEntry> getApplications(){
        return applications;
    }

    //função responsavel a fazer o Parser o parse do XML concatenar as Strings
    public boolean parse(String  jsonResponse){ //<< recebo por parametro uma String XML
        boolean status = true; // parse com sucesso?  declaração e inicialização
        FeedEntry entry; // entrada do RSS a ser lida declaração e inicialização tipo "FeedEntry"
        String num;
        String name;
        String img;
        String height;
        String weight;
        JSONArray jsonArray;
        JSONObject oneObject = null;

        try{
            JSONObject jObject = new JSONObject(jsonResponse);
            JSONArray jArray =  jObject.getJSONArray("pokemon");

            for (int i = 0; i < jArray.length(); i++){
                try {
                    entry = new FeedEntry();
                    List<String> type = new ArrayList<>();

                    oneObject = jArray.getJSONObject(i);
                    num = oneObject.getString("num");
                    name = oneObject.getString("name");
                    img = oneObject.getString("img");
                    height = oneObject.getString("height");
                    weight = oneObject.getString("weight");
                    jsonArray = oneObject.getJSONArray("type");
                    for (int a=0; a<jsonArray.length(); a++) {
                        type.add(jsonArray.getString(a));

                    }
                    entry.setNum(num);
                    entry.setName(name);
                    entry.setImgURL(img);
                    entry.setHeight(height);
                    entry.setWeight(weight);
                    //  entry.setType(type);

                    applications.add(entry);


                }catch (JSONException e) {

                    e.printStackTrace();

                }
            }

        } catch (Exception ex) {
            Log.e(TAG, "parse: Erro ao fazer parse: " + ex.getMessage());
            status = false;
        }

        return status;
    }
}