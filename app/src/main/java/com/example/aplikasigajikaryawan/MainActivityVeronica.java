package com.example.aplikasigajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasigajikeryawan.R;

public class MainActivityVeronica extends AppCompatActivity {

    private LinearLayout btnGaji, btnPetunjuk, btnTentang, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_veronica);

        btnGaji = findViewById(R.id.btnGaji);
        btnPetunjuk = findViewById(R.id.btnPetunjuk);
        btnTentang = findViewById(R.id.btnTentang);
        btnExit = findViewById(R.id.btnExit);

        btnGaji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityVeronica.this, GajiActivityVeronica.class);
                startActivity(intent);
            }
        });

        btnPetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityVeronica.this, PetunjukActivityVeronica.class);
                startActivity(intent);
            }
        });

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityVeronica.this, TentangActivityVeronica.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivityVeronica.this)
                        .setTitle("Keluar Aplikasi")
                        .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
                        .setPositiveButton("Ya", (dialog, which) -> finishAffinity())
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
    }
}