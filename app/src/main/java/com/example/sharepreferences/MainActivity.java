package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_mail);

        //obtener datos del archivo que se ha creado (parametro 1 archivo creado, )
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Coloca lo que encontraste a la tiqueta et1
        et1.setText(preferences.getString("mail", ""));
    }

    //Metodo para el button Guardar
    public void guardar (View view){
        //obtener datos del archivo que se ha creado
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Para guardar en el archivo y editarlo
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        //colocar cadena de texto con la referencia mail
        Obj_editor.putString("mail", et1.getText().toString());
        //confirmar el guardar
        Obj_editor.commit();
        //Finalizar activity
        finish();
    }
}