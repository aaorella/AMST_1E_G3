package com.grupo2.app_pingui_g3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Temperatura extends AppCompatActivity {
    String token;
    RequestQueue queue;
    TextView temp;
    TextView temp2;
    TextView temp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        token = getIntent().getExtras().getString("token");
        queue = Volley.newRequestQueue(this);
        temp = findViewById(R.id.textTemp);
        temp2 = findViewById(R.id.texttemp1);
        temp3 = findViewById(R.id.texttemp3);
        getTemps1();
        getTemps2();
        getTemps3();
    }
    public void getTemps1(){
        String url= "https://amstdb.herokuapp.com/db/registroDeFrios/1";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String value = response.getString("temperatura");
                    //String a[] = value.split(",");
                    System.out.println(value);
                    temp.setText(value);

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

    public void getTemps2(){
        String url= "https://amstdb.herokuapp.com/db/registroDeFrios/2";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String value = response.getString("temperatura");
                    //String a[] = value.split(",");
                    System.out.println(value);
                    temp2.setText(value);

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

    public void getTemps3(){
        String url= "https://amstdb.herokuapp.com/db/registroDeFrios/3";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    String value = response.getString("temperatura");
                    //String a[] = value.split(",");
                    System.out.println(value);
                    temp3.setText(value);

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
    /*
    public void getTemps11(){
        String url= "https://amstdb.herokuapp.com/db/registroDeFrios";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response);
                    response = (JSONArray) response;
                    LayoutInflater layoutInflator = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    LinearLayout insertPoint = (LinearLayout) findViewById(R.id.lineal);
                    ArrayList views = new ArrayList<>();
                    for (int i = 0; i<response.length(); i++){
                        TextView w = new TextView(getApplicationContext());


                        views.add()
                    }
                    String value = response.getString("temperatura");
                    //String a[] = value.split(",");
                    System.out.println(value);
                    temp2.setText(value);

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
    }*/
}
