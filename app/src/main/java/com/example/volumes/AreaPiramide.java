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

public class AreaPiramide extends AppCompatActivity {

 private EditText baseEditText;
 private EditText alturaEditText;
 private TextView resultadoTextView;
 private Button calcularButton;
 private Button voltarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piramide);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        baseEditText = findViewById(R.id.baseEditText);
        alturaEditText = findViewById(R.id.alturaEditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        calcularButton = findViewById(R.id.calcularButton);
        voltarButton = findViewById(R.id.voltarButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseString = baseEditText.getText().toString();
                String alturaString = alturaEditText.getText().toString();
                if (!baseString.equals("") && !alturaString.equals("")) {
                    double base = Double.parseDouble(baseString);
                    double altura = Double.parseDouble(alturaString);
                    Piramide piramide = new Piramide(base, altura);
                    String volume = piramide.calcularArea();
                    resultadoTextView.setText( piramide.toString() + volume);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_LONG).show();
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