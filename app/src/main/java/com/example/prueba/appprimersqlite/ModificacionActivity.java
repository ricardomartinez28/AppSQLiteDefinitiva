package com.example.prueba.appprimersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;

public class ModificacionActivity extends AppCompatActivity {

    EditText etId;
    EditText etNombre;
    EditText etEmail;
    ContactosDatasource cds;
    Button btnBuscar;
    Button btnGuardar;
    Contacto contacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificacion);
        etId=findViewById(R.id.etId);
        etNombre=findViewById(R.id.etNewNombre);
        etEmail=findViewById(R.id.etNewEmail);

        btnBuscar= findViewById(R.id.btnBuscar);
        btnGuardar=findViewById(R.id.btnGuardar);
        cds= new ContactosDatasource(this);
    }

    public void buscar(View v){
        String id= etId.getText().toString().trim();

        if(id.isEmpty()){
            Toast.makeText(this, "Debes introducir un id",Toast.LENGTH_LONG).show();
        }else{
             contacto= cds.consultarContacto(Integer.parseInt(id));

            if(contacto!=null){
                etId.setEnabled(false);
                btnBuscar.setEnabled(false);

                etNombre.setEnabled(true);
                etEmail.setEnabled(true);
                btnGuardar.setEnabled(true);

                etNombre.setText(contacto.getName());
                etEmail.setText(contacto.getEmail());

            }else{
                Toast.makeText(this, "No se ha encontrado el id",Toast.LENGTH_LONG).show();
            }

        }
    }
    public void guardarM(View v){

        String nombre=etNombre.getText().toString().trim();
        String email=etEmail.getText().toString().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Debes introducir todos los datos",Toast.LENGTH_LONG).show();

        } else {
            contacto.setName(nombre);
            contacto.setEmail(email);

            cds.modificarContacto(contacto);

            Toast.makeText(this, "Se han modificado correctamente",Toast.LENGTH_LONG).show();

            etId.setEnabled(true);
            btnBuscar.setEnabled(true);

            etNombre.setEnabled(false);
            etEmail.setEnabled(false);
            btnGuardar.setEnabled(false);



        }

    }
    public void cancelarM(View v){

        finish();

    }

}
