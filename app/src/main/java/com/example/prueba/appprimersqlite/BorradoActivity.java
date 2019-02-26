package com.example.prueba.appprimersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;

public class BorradoActivity extends AppCompatActivity {

    EditText etId;
    EditText etNombre;
    EditText etEmail;
    ContactosDatasource cds;
    Button btnBuscar;
    Button btnBorrar;
    Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrado);

        etId=findViewById(R.id.etIdB);
        etNombre=findViewById(R.id.etNombreB);
        etEmail=findViewById(R.id.etEmailB);

        btnBuscar= findViewById(R.id.btnBuscarB);
        btnBorrar=findViewById(R.id.btnBorrar);
        cds= new ContactosDatasource(this);
    }

    public void buscarB(View v){
        String id= etId.getText().toString().trim();

        if(id.isEmpty()){
            Toast.makeText(this, "Debes introducir un id",Toast.LENGTH_LONG).show();
        }else{
            contacto= cds.consultarContacto(Integer.parseInt(id));

            if(contacto!=null){
                etId.setEnabled(false);
                btnBuscar.setEnabled(false);


                btnBorrar.setEnabled(true);

                etNombre.setText(contacto.getName());
                etEmail.setText(contacto.getEmail());

            }else{
                Toast.makeText(this, "No se ha encontrado el id",Toast.LENGTH_LONG).show();
            }

        }

    }
    public void borrarB(View v){

            cds.borrarContacto(contacto.getId());

            Toast.makeText(this, "Se han Borrado correctamente",Toast.LENGTH_LONG).show();

            etId.setText("");
            etNombre.setText("");
            etEmail.setText("");

            etId.setEnabled(true);
            btnBuscar.setEnabled(true);


            btnBorrar.setEnabled(false);





    }
    public void cancelarB(View v){

            finish();
    }

}
