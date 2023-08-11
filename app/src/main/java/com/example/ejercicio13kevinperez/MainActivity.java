package com.example.ejercicio13kevinperez;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio13kevinperez.PersonDataSource;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etApellidos, etEdad, etCorreo, etDireccion;
    private Button btnSalvar;
    private PersonDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etEdad = findViewById(R.id.etEdad);
        etCorreo = findViewById(R.id.etCorreo);
        etDireccion = findViewById(R.id.etDireccion);
        btnSalvar = findViewById(R.id.btnSalvar);

        dataSource = new PersonDataSource(this);
        dataSource.open();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                String correo = etCorreo.getText().toString();
                String direccion = etDireccion.getText().toString();

                Person newPerson = new Person(nombre, apellidos, edad, correo, direccion);
                dataSource.insertPerson(newPerson);

                // Clear input fields after saving
                etNombre.setText("");
                etApellidos.setText("");
                etEdad.setText("");
                etCorreo.setText("");
                etDireccion.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }
}

