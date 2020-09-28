package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Cadastro extends AppCompatActivity {

    EditText editTextTipo, editTextMedidas, editTextPreco, editTextCor, editTextMaterial, editTextCod;

    private static final int CAMERA = 0;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editTextTipo = (EditText)findViewById(R.id.editTextTipo);
        editTextMedidas = (EditText)findViewById(R.id.editTextMedidas);
        editTextPreco = (EditText)findViewById(R.id.editTextPreco);
        editTextCor = (EditText)findViewById(R.id.editTextCor);
        editTextMaterial = (EditText)findViewById(R.id.editTextMaterial);
        editTextCod = (EditText)findViewById(R.id.editTextCod);

        imgFoto = (ImageView)findViewById(R.id.imgFoto);
    }
    public void Cadastrar(View view){
        Intent intent = new Intent(Cadastro.this, CadastroFinal.class);
        intent.putExtra("Valor", editTextTipo.getText().toString());
        intent.putExtra("Valor2", editTextMedidas.getText().toString());
        intent.putExtra("Valor3", editTextPreco.getText().toString());
        intent.putExtra("Valor4", editTextCor.getText().toString());
        intent.putExtra("Valor5", editTextMaterial.getText().toString());
        intent.putExtra("Valor6", editTextCod.getText().toString());
        startActivity(intent);
    }
    public void Foto(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!= null){
            startActivityForResult(takePictureIntent, CAMERA);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgFoto.setImageBitmap(imageBitmap);
        }
    }
}
