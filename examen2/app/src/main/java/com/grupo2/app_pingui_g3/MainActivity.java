package com.grupo2.app_pingui_g3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    TextView usuario;
    TextView pass;
    RequestQueue queue;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        usuario = (TextView) findViewById(R.id.txtUser);
        pass = (TextView) findViewById(R.id.txtUser);
        start = (Button)findViewById(R.id.button);

    }

    public void login(View view){
        String url= "https://amstdb.herokuapp.com/db/nuevo-jwt";
        Map<String, String> params = new HashMap<>();
        params.put("username",usuario.getText().toString());
        params.put("password",pass.getText().toString());
        JSONObject a = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, a, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String token = response.getString("token");
                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    intent.putExtra("token", token);
                    startActivity(intent);
                } catch (JSONException e) {
                    Toast a = Toast.makeText(getApplicationContext(), "Mal parseado", Toast.LENGTH_LONG);
                    a.show();
                    //e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("nada");
                Toast a = Toast.makeText(getApplicationContext(), "Credenciales erroneas", Toast.LENGTH_LONG);
                a.show();
            }
        });
        queue.add(request);

    }
}
