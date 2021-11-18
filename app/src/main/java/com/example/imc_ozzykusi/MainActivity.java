package com.example.imc_ozzykusi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void Salud(View view) {startActivity(new Intent(this, Salud.class));
    }

    public void salir(View view) {finish();
    }


}