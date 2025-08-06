package com.uj.echocrisismain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnSetProfile, btnEmergencyContact;
    TextView tvWelcome; // Optional: TextView for welcome message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetProfile = findViewById(R.id.btnSetProfile);
        btnEmergencyContact = findViewById(R.id.btnEmergencyContact);
        tvWelcome = findViewById(R.id.tvWelcome); // Make sure this TextView exists in activity_main.xml

        // ✅ Get name from intent
        String userName = getIntent().getStringExtra("username");

        if (userName != null && !userName.isEmpty()) {
            // ✅ Option 1: Show welcome toast
            Toast.makeText(this, "Welcome, " + userName + "!", Toast.LENGTH_LONG).show();

            // ✅ Option 2: Show welcome message in TextView
            tvWelcome.setText("Welcome, " + userName + "!");
        }

        btnSetProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, ProfileSetupActivity.class);
            startActivity(intent);
        });

        btnEmergencyContact.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, EmergencyContact.class);
            startActivity(intent);
        });
    }
}
