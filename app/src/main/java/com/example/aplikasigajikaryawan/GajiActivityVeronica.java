package com.example.aplikasigajikaryawan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasigajikeryawan.R;

public class GajiActivityVeronica extends AppCompatActivity {

    private EditText etNik, etNama, etGajiPokok, etTunjanganJabatan, etJumlahHariKerja;
    private EditText etTunjanganMakan, etTunjanganTransportasi, etGajiKotor, etGajiBersih;
    private Button btnHitung, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_veronica);

        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjanganJabatan = findViewById(R.id.etTunjanganJabatan);
        etJumlahHariKerja = findViewById(R.id.etJumlahHariKerja);

        etTunjanganMakan = findViewById(R.id.etTunjanganMakan);
        etTunjanganTransportasi = findViewById(R.id.etTunjanganTransportasi);
        etGajiKotor = findViewById(R.id.etGajiKotor);
        etGajiBersih = findViewById(R.id.etGajiBersih);

        btnHitung = findViewById(R.id.btnHitung);
        btnKembali = findViewById(R.id.btnKembali);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sGajiPokok = etGajiPokok.getText().toString();
                String sTunjanganJabatan = etTunjanganJabatan.getText().toString();
                String sHariKerja = etJumlahHariKerja.getText().toString();

                if (sGajiPokok.isEmpty() || sTunjanganJabatan.isEmpty() || sHariKerja.isEmpty()) {
                    Toast.makeText(GajiActivityVeronica.this, "Mohon isi semua data dengan benar", Toast.LENGTH_SHORT).show();
                    return;
                }

                double gajiPokok = Double.parseDouble(sGajiPokok);
                double tunjanganJabatan = Double.parseDouble(sTunjanganJabatan);
                int hariKerja = Integer.parseInt(sHariKerja);

                // Simulasi Perhitungan
                double tunjanganMakan = hariKerja * 25000;       // Contoh: 25rb per hari
                double tunjanganTransportasi = hariKerja * 20000; // Contoh: 20rb per hari
                double gajiKotor = gajiPokok + tunjanganJabatan + tunjanganMakan + tunjanganTransportasi;
                double pajak = gajiKotor * 0.05;                  // Pajak 5%
                double gajiBersih = gajiKotor - pajak;

                // Tampilkan hasil ke EditText output
                etTunjanganMakan.setText(String.valueOf(tunjanganMakan));
                etTunjanganTransportasi.setText(String.valueOf(tunjanganTransportasi));
                etGajiKotor.setText(String.valueOf(gajiKotor));
                etGajiBersih.setText(String.valueOf(gajiBersih));
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kembali ke halaman sebelumnya
            }
        });
    }
}