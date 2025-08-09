

package com.uj.echocrisismain;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LegalHelpActivity extends AppCompatActivity {

    Button btnGoToInsurance, btnFinancialHelp, btnMedicalHelp , btnBankingHelp;
    TextView txtWelcome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_help);

        btnGoToInsurance = findViewById(R.id.btnGoToInsurance);
        btnFinancialHelp = findViewById(R.id.btnFinancialHelp);
        btnMedicalHelp = findViewById(R.id.btnMedicalHelp);
        btnBankingHelp = findViewById(R.id.btnBankingHelp);
        txtWelcome = findViewById(R.id.txtWelcome);


        // Receiving data from MainActivity
        String username = getIntent().getStringExtra("username");
        txtWelcome.setText("Welcome, " + username);

        btnGoToInsurance.setOnClickListener(v -> {
            Intent intent = new Intent(LegalHelpActivity.this, InsuranceClaimActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        btnFinancialHelp.setOnClickListener(v -> {
            Intent intent = new Intent(LegalHelpActivity.this, FinancialHelpActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        btnMedicalHelp.setOnClickListener(v -> {
            Intent intent = new Intent(LegalHelpActivity.this, MedicalHelpActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        btnBankingHelp.setOnClickListener(v -> {
            Intent intent = new Intent(LegalHelpActivity.this, BankingHelpActivity.class);
            startActivity(intent);
        });
    }
}