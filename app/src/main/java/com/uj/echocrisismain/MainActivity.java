package com.uj.echocrisismain; // keep your main package

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSetProfile, btnEmergencyContact, buttonInsurance;
    TextView tvWelcome; // Optional welcome message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all buttons and TextView
        btnSetProfile = findViewById(R.id.btnSetProfile);
        btnEmergencyContact = findViewById(R.id.btnEmergencyContact);
        tvWelcome = findViewById(R.id.tvWelcome); // Make sure this TextView exists in your layout

        // Get username from intent extras
        String userName = getIntent().getStringExtra("username");

        if (userName != null && !userName.isEmpty()) {
            Toast.makeText(this, "Welcome, " + userName + "!", Toast.LENGTH_LONG).show();
            tvWelcome.setText("Welcome, " + userName + "!");
        }

        // Button to go to Profile Setup
        btnSetProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileSetupActivity.class);
            startActivity(intent);
        });

        // Button to go to Emergency Contact
        btnEmergencyContact.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EmergencyContact.class);
            startActivity(intent);
        });

        // Button to go to Insurance/Dashboard screen

    }
}
