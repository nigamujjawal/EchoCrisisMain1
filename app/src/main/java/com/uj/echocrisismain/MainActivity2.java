package com.uj.echocrisismain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnSetProfile, btnEmergencyContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetProfile = findViewById(R.id.btnSetProfile);
        btnEmergencyContact = findViewById(R.id.btnEmergencyContact);

        btnSetProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, ProfileSetupActivity.class);
            startActivity(intent);
        });

        btnEmergencyContact.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, EmergencyContact.class); // Your EmergencyContact screen
            startActivity(intent);
        });
    }
}
