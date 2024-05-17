package com.example.volumes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.spec.ECParameterSpec;
import java.text.DecimalFormat;

public class EsferaActivity extends AppCompatActivity {

    private EditText raioEditText;
    private Button calcularButton;
    private Button voltarButton;

    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_esfera);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        raioEditText = findViewById(R.id.raio);
        calcularButton = findViewById(R.id.buttonCalcular);
        voltarButton = findViewById(R.id.buttonVoltar);
        resposta = findViewById(R.id.reposta);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Tenta converter a entrada recebida
                    Double.parseDouble(raioEditText.getText().toString());

                    String raioString = raioEditText.getText().toString();
                    double raio = Double.valueOf(raioString);

                    Esfera esfera = new Esfera(raio);
                    double volume = esfera.calcularVolume();
                    DecimalFormat df = new DecimalFormat("0.00");
                    String valorFormatado = df.format(volume);


                    resposta.setText("O volume da esfera é aproximadamente " + valorFormatado);
                } catch (NumberFormatException e) {
                    // Se a conversão falhar, a entrada é inválida
                    // Exibir mensagem de erro
                    Toast.makeText(getApplicationContext(), "Entrada inválida. Digite o valor do raio.", Toast.LENGTH_LONG).show();
                }
            }
        });

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}