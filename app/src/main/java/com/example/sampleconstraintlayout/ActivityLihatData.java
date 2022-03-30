package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {

    TextView tvnama,tvnomor;

    Bundle bundle = getIntent().getExtras();

    String nama = bundle.getString( "a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (nama)
        {
            case "erda":
                tvnama.setText("Erda");
                tvnomor.setText("087723658056");
                break;

            case "wyne":
                tvnama.setText("Wyne");
                tvnomor.setText("081324362535");
                break;

            case "astuti":
                tvnama.setText("Astuti");
                tvnomor.setText("0899845u2490");
                break;

            case "utami":
                tvnama.setText("Utami");
                tvnomor.setText("089984552490");
                break;

            case "ervita":
                tvnama.setText("Ervita");
                tvnomor.setText("089984582491");
                break;

            case "kusuma":
                tvnama.setText("Kusuma");
                tvnomor.setText("089984592490");
                break;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
    }
}