package com.example.imc_ozzykusi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Salud extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtAltura;
    Button btnCalcular, btnLimpiar;
    RadioButton btnMujer, btnHombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salud);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnMujer = (RadioButton) findViewById(R.id.btnMujer);
        btnHombre = (RadioButton) findViewById(R.id.btnHombre);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularIMC();
            }
        });
    }
    private void Limpiar ()
    {
        txtNombre.setText("");
        txtAltura.setText("");
        txtPeso.setText("");
    }

    private String MensajeIMC (double IMC)
    {
        String mensaje = "";
        if (IMC < 16)
            mensaje =" Peso demasiado bajo ";
        else if (IMC >= 16 & IMC < 17)
            mensaje = " Peso muy bajo ";
        else if (IMC >=17 & IMC < 18.49)
            mensaje = " Peso Bajo ";
        else if (IMC >=18.50 & IMC < 24.99)
            mensaje = " Peso Ideal ";
        else if (IMC >=25 & IMC < 29.99)
            mensaje = " Obesidad ";
        else if (IMC >=30 & IMC < 34.99)
            mensaje = " Obesidad alta ";
        else if (IMC <40)
            mensaje = " Obesidad Demasiado alta ";
        else
            mensaje = " Otro tipo de IMC ";
        return mensaje;
    }

    private void CalcularIMC ()
    {
        String nombre = txtNombre.getText().toString();
        Double altura = Double.valueOf(txtAltura.getText().toString());
        Double peso = Double.valueOf(txtPeso.getText().toString());
        double IMC = peso / Math.pow(altura, 2);

        Toast.makeText(this, " Tu IMC es:  " + String.format(" %.2f ", IMC) + MensajeIMC(IMC), Toast.LENGTH_SHORT).show();
        if (btnMujer.isChecked()== true)
            Toast.makeText(this, "Eres mujer", Toast.LENGTH_SHORT).show();
        else if(btnHombre.isChecked()== true)
            Toast.makeText(this, "Eres Hombre", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No seleccionaste ningun genero", Toast.LENGTH_SHORT).show();
    }



    public void rec(View view) {startActivity(new Intent(this, Recomendaciones.class));
    }

}


