package com.example.bob;

import android.os.Bundle;


import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView txtCount;

    int licz = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            licz = savedInstanceState.getInt("licz");
        }

        txtCount = findViewById(R.id.textView);
        txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");
        Button buttonDisable = findViewById(R.id.buttonDisable);
        buttonDisable.setOnClickListener(v -> {
            buttonDisable.setEnabled(false);
            licz ++;
            txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");
            Toast.makeText(MainActivity.this, "Kliknięto przycisk",Toast.LENGTH_SHORT).show();
        });
        Button buttonEnable = findViewById(R.id.buttonEnable);
        buttonEnable.setOnClickListener(v -> buttonDisable.setEnabled(true));

        Button buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(v -> {
            licz = 0;
            txtCount.setText("Kliknięto "+String.valueOf(licz)+" razy");
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("licz", licz);
    }


}