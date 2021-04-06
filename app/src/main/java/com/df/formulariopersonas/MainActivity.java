package com.df.formulariopersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lvRespuesta;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtEdad;
    private EditText txtSalario;
    private EditText txtCargo;
    private EditText txtEmail;
    private Button btnGuardar;
    private Button btnEdades;
    private Button btnSalarioPro;
    private Button btnListar;
    private ArrayAdapter<String> adaptador;
    private ArrayList<Persona> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvRespuesta = findViewById(R.id.lvRespuesta);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        txtSalario = findViewById(R.id.txtSalario);
        txtCargo = findViewById(R.id.txtCargo);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEdades = findViewById(R.id.btnEdades);
        btnSalarioPro = findViewById(R.id.btnSalariosPro);
        btnListar = findViewById(R.id.btnListar);

        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        btnEdades.setOnClickListener(this);
        btnSalarioPro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuardar) {
            guardarPersonas();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personas);
            lvRespuesta.setAdapter(adaptador);
        }
        if (v.getId() == R.id.btnEdades) {
            mymEdad();
            ArrayList<String> edadesPersonas = new ArrayList<>();
            String menorEdad = "la persona de menor edad es: " + personas.get(0);
            String mayorEdad = "la persona de mayor edad es: " + personas.get(personas.size() - 1);
            edadesPersonas.add(menorEdad);
            edadesPersonas.add(mayorEdad);
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, edadesPersonas);
            lvRespuesta.setAdapter(adaptador);
        }
        if (v.getId() == R.id.btnSalariosPro) {
            mymSalario();
            ArrayList<String> salariosPersonas = new ArrayList<>();
            String menorSalario = "La persona con monor salario es: " + "\n" + personas.get(0);
            String mayorSalario = "la persona de mayor salario es: " + "\n" + personas.get(personas.size() - 1);
            String promedioSalario = "El salario promedio de los colaboradores es: " + "\n" + salarioPromedio();
            salariosPersonas.add(menorSalario);
            salariosPersonas.add(mayorSalario);
            salariosPersonas.add(promedioSalario);
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, salariosPersonas);
            lvRespuesta.setAdapter(adaptador);
        }
        if (v.getId() == R.id.btnListar) {
            ArrayList<String> salarioXCargo = new ArrayList<>();
            String cargo1 = "ANALISTA";
            String cargo2 = "PROG_JUNIOR";
            String cargo3 = "PROG_SENIOR";
            String cargo4 = "QA";

            String mensaje1 = "";
            String mensaje2 = "";
            String mensaje3 = "";
            String mensaje4 = "";
            for (Persona cargo : personas) {
                if (cargo.getCargo().equals(cargo1)) {
                    mensaje1 = "el salario promedio de un ANALISTA es:" + (cargo1)+"\n"+
                    "El numero de ANALISTAS es: " +personasXCargo(cargo1);
                } else if (cargo.getCargo().equals(cargo2)) {
                    mensaje2 = "el salario promedio de un PROG_JUNIOR es:" + salarioPromedioXCargo(cargo2)+"\n" +
                    " El numero de PROG_JUNIOR es: " +personasXCargo(cargo2);
                } else if (cargo.getCargo().equals(cargo3)) {
                    mensaje3 = "el salario promedio de un PROG_SENIOR es:" + salarioPromedioXCargo(cargo3)+"\n"+
                    "El numero de PROG_SENIOR es: "+personasXCargo(cargo3);
                } else if (cargo.getCargo().equals(cargo4)) {
                    mensaje4 = "el salario promedio de un QA es:" + salarioPromedioXCargo(cargo4)+"\n"+
                    "El numero de QA es:"+personasXCargo(cargo4);
                }
            }
            salarioXCargo.add(mensaje1);
            salarioXCargo.add(mensaje2);
            salarioXCargo.add(mensaje3);
            salarioXCargo.add(mensaje4);
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, salarioXCargo);
            lvRespuesta.setAdapter(adaptador);
        }


    }


    private void guardarPersonas() {
        String Nombre = txtNombre.getText().toString();
        String Apellido = txtApellido.getText().toString();
        String Cargo = txtCargo.getText().toString();
        String Email = txtEmail.getText().toString();
        int Edad = Integer.parseInt(txtEdad.getText().toString());
        double Salario = Double.parseDouble(txtSalario.getText().toString());

        Persona persona = new Persona(Nombre, Apellido, Cargo, Email, Edad, Salario);
        personas.add(persona);
    }

    private void mymEdad() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return new Integer(o1.getEdad()).compareTo(new Integer(o2.getEdad()));
            }
        });
    }

    private void mymSalario() {
        Collections.sort(personas, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return new Double(o1.getSalario()).compareTo(new Double(o2.getSalario()));
            }
        });
    }

    private Double salarioPromedio() {
        int contador = 0;
        double salarioTotal = 0;
        double promedio = 0;
        for (Persona salaPersona : personas) {
            salarioTotal += salaPersona.getSalario();
            contador++;
        }
        promedio = salarioTotal / contador;
        return promedio;
    }

    private Double salarioPromedioXCargo(String cargo) {
        int contador = 0;
        double salarioTotal = 0;
        double promedio = 0;

        for (Persona salaPersona : personas) {

            if (salaPersona.getCargo().equals(cargo)) {
                salarioTotal += salaPersona.getSalario();
                contador++;
            }

        }
        promedio = salarioTotal / contador;
        return promedio;
    }

    private int personasXCargo(String cargo) {
        int contador = 0;
        for (Persona salaPersona : personas) {

            if (salaPersona.getCargo().equals(cargo)) {
                contador++;
            }

        }

        return contador;
    }
}
