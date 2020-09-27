package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = (EditText)findViewById(R.id.editTextUser);

    }
    public void Entrar(View view) {
        Intent intent = new Intent(MainActivity.this, Browse.class);
        intent.putExtra("Valor", editTextUser.getText().toString());
        startActivity(intent);
        finish();
    }
}
