package com.grupo2.app_pingui_g3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Recorrido extends AppCompatActivity {
    String token;
    RequestQueue queue;
    TextView rec;
    TextView dest;
    TextView f1;
    TextView f2;

    TextView rec2;
    TextView dest2;
    TextView f12;
    TextView f22;

    TextView rec3;
    TextView dest3;
    TextView f13;
    TextView f23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);
        token = getIntent().getExtras().getString("token");
        queue = Volley.newRequestQueue(this);
        rec = findViewById(R.id.textRec);
        dest = findViewById(R.id.textdest);
        f1 = findViewById(R.id.textf1);
        f2 = findViewById(R.id.textf2);

        rec2 = findViewById(R.id.textRec2);
        dest2 = findViewById(R.id.textDest2);
        f12 = findViewById(R.id.textf12);
        f22 = findViewById(R.id.textf22);

        rec3 = findViewById(R.id.textRec3);
        dest3 = findViewById(R.id.textdest3);
        f13 = findViewById(R.id.textf13);
        f23 = findViewById(R.id.textf23);

        getTemps1();
        getTemps2();
        getTemps3();
    }

    public void getTemps1(){
        String url= " https://amstdb.herokuapp.com/db/recorrido/1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String v1 = response.getString("origen");
                    String v2 = response.getString("destino");
                    String v3 = response.getString("fecha_inicio");
                    String v4 = response.getString("fecha_fin");


                    //String a[] = value.split(",");

                    rec.setText("Origen: " + v1);
                    dest.setText("Destino: " + v2);
                    f1.setText("Fecha inicio: " + v3);
                    f2.setText("Fecha fin: " + v4);
                } catch (JSONException e) {
                    System.out.println("Error parseo");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("nada");
                System.out.println(error);
            }
        }){
            @Override
            public Map<String,String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String,String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };

        queue.add(request);
    }



    public void getTemps2() {
        String url = " https://amstdb.herokuapp.com/db/recorrido/2";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String v1 = response.getString("origen");
                    String v2 = response.getString("destino");
                    String v3 = response.getString("fecha_inicio");
                    String v4 = response.getString("fecha_fin");


                    rec2.setText("Origen: " + v1);
                    dest2.setText("Destino: " + v2);
                    f12.setText("Fecha inicio: " + v3);
                    f22.setText("Fecha fin: " + v4);
                } catch (JSONException e) {
                    System.out.println("Error parseo");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("nada");
                System.out.println(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };

        queue.add(request);
    }
    public void getTemps3() {
        String url = " https://amstdb.herokuapp.com/db/recorrido/3";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String v1 = response.getString("origen");
                    String v2 = response.getString("destino");
                    String v3 = response.getString("fecha_inicio");
                    String v4 = response.getString("fecha_fin");


                    rec3.setText("Origen: " + v1);
                    dest3.setText("Destino: " + v2);
                    f13.setText("Fecha inicio: " + v3);
                    f23.setText("Fecha fin: " + v4);
                } catch (JSONException e) {
                    System.out.println("Error parseo");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("nada");
                System.out.println(error);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "JWT " + token);
                System.out.println(token);
                return params;
            }
        };

        queue.add(request);
    }
}
