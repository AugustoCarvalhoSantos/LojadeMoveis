package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextUser, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = (EditText)findViewById(R.id.editTextUser);
        editTextSenha = (EditText)findViewById(R.id.editTextSenha);

    }
    public void Entrar(View view) {
        if(validacao()) {
            Intent intent = new Intent(MainActivity.this, Browse.class);
            intent.putExtra("Valor", editTextUser.getText().toString());
            startActivity(intent);
        }
    }
    public boolean validacao(){

        boolean retorno=true;

        String User = editTextUser.getText().toString();
        String Senha = editTextSenha.getText().toString();
        if(User.isEmpty() || Senha.isEmpty()){
            retorno = false;
            editTextUser.setError("Preencha este campo!");
            editTextSenha.setError("Preencha este campo!");
        }
        return retorno;
    }
}
