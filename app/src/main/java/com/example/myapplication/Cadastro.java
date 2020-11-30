package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Cadastro extends AppCompatActivity {

    EditText editTextTipo, editTextMedidas, editTextPreco, editTextCor, editTextMaterial, editTextCod;
    Button btnCad;
    private static final int CAMERA = 0;
    ImageView imgFoto;

    BancoDados db = new BancoDados(this);

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

        btnCad = (Button)findViewById(R.id.btnCad);

    btnCad.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            String cod = editTextCod.getText().toString();
            String tipo = editTextTipo.getText().toString();
            String medida = editTextMedidas.getText().toString();
            String preco =  editTextPreco.getText().toString();
            String cor = editTextCor.getText().toString();
            String material = editTextMaterial.getText().toString();

            if(cod.isEmpty()){
                editTextCod.setError("Este campo é obrigatorio");
            } else if(tipo.isEmpty()){
                //insert
                db.addMovel(new Movel(cod, tipo, medida, preco, cor, material));
            }
        }
    });
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
