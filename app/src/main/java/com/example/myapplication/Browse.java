package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Browse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

    }
    public void Cadastro(View view) {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }
    public void Oferta(View view) {
        Intent intent = new Intent(this, Oferta.class);
        startActivity(intent);
    }
    public void Mesa(View view) {
        Intent intent = new Intent(this, Mesa.class);
        startActivity(intent);
    }

}
