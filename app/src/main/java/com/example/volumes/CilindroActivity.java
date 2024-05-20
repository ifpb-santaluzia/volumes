package com.example.volumes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CilindroActivity extends AppCompatActivity {
    private EditText raioEditText;
    private EditText alturaEditText;
    private TextView resultadoTextView;
    private Button calcularButton;
    private Button voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cilindro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        raioEditText = findViewById(R.id.raioEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        calcularButton = findViewById(R.id.calcularButton);
        voltarButton = findViewById(R.id.voltarButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String raioString = raioEditText.getText().toString();
                String alturaString = alturaEditText.getText().toString();

                double raio = Double.parseDouble(raioString);
                double altura = Double.parseDouble(alturaString);

                Cilindro cilindro = new Cilindro(raio, altura);

                resultadoTextView.setText(cilindro.toString());
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