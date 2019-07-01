package com.grupo2.app_pingui_g3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);
        token = getIntent().getExtras().getString("token");

    }
    public void irTemp(View v){
        Intent i = new Intent(getApplicationContext(), Temperatura.class);
        i.putExtra("token", token);
        startActivity(i);
    }

    public void irRec(View v){
        Intent i = new Intent(getApplicationContext(), Recorrido.class);
        i.putExtra("token", token);
        startActivity(i);
    }
    public void salir(View v){
        this.finishAffinity();
        Toast toast = Toast.makeText(getApplicationContext(), "APP finalizada", Toast.LENGTH_LONG);
        toast.show();
    }

}
