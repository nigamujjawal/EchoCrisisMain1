package com.uj.echocrisismain; // ✅ Replace with your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button btnMentalSupport, btnLegalHelp, btnShowScheme, btnSuggestShelter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard); // Make sure you created this XML layout

        // Initialize Buttons
        btnMentalSupport = findViewById(R.id.btnMentalSupport);
        btnLegalHelp = findViewById(R.id.btnLegalHelp);
        btnShowScheme = findViewById(R.id.btnShowScheme);
        btnSuggestShelter = findViewById(R.id.btnSuggestShelter);

        // Set click listeners
        btnMentalSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MentalSupportActivity.class);
                startActivity(intent);
            }
        });

        btnLegalHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, LegalHelpActivity.class);
                startActivity(intent);
            }
        });

        btnShowScheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, SchemeActivity.class);
                startActivity(intent);
            }
        });

        btnSuggestShelter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ShelterActivity.class);
                startActivity(intent);
            }
        });
    }
}
