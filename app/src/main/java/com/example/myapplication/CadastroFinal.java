package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CadastroFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_final);

        txtTipo = findViewById(R.id.txtTipo);
        String valor = getIntent().getStringExtra("Valor");
        txtTipo.setText("Tipo: " + valor);

        txtMedidas = findViewById(R.id.txtMedidas);
        String valor2 = getIntent().getStringExtra("Valor2");
        txtMedidas.setText("Medidas: " + valor2);

        txtPreco = findViewById(R.id.txtPreco);
        String valor3 = getIntent().getStringExtra("Valor3");
        txtPreco.setText("Preço: R$" + valor3);

        txtCor = findViewById(R.id.txtCor);
        String valor4 = getIntent().getStringExtra("Valor4");
        txtCor.setText("Cor: " + valor4);

        txtMaterial = findViewById(R.id.txtMaterial);
        String valor5 = getIntent().getStringExtra("Valor5");
        txtMaterial.setText("Meterial: " + valor5);

        txtCod = findViewById(R.id.txtCod);
        String valor6 = getIntent().getStringExtra("Valor6");
        txtCod.setText("Seu Código: " + valor6);

        }
    public void Back(View view) {
        Intent intent = new Intent(this, Browse.class);
        startActivity(intent);
    }
}
