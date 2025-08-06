package com.uj.echocrisismain;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvPhone, tvEmail, tvDOB, tvLocation, tvState,
            tvCrisisType, tvRecoveryStage, tvOccupation, tvMedicalNeeds,
            tvGender, tvUrgentHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvDOB = findViewById(R.id.tvDOB);
        tvLocation = findViewById(R.id.tvLocation);
        tvState = findViewById(R.id.tvState);
        tvCrisisType = findViewById(R.id.tvCrisisType);
        tvRecoveryStage = findViewById(R.id.tvRecoveryStage);
        tvOccupation = findViewById(R.id.tvOccupation);
        tvMedicalNeeds = findViewById(R.id.tvMedicalNeeds);
        tvGender = findViewById(R.id.tvGender);
        tvUrgentHelp = findViewById(R.id.tvUrgentHelp);

        // Load profile from Firebase
        loadUserProfile();
    }

    private void loadUserProfile() {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(uid);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    UserProfile profile = snapshot.getValue(UserProfile.class);
                    if (profile != null) {
                        tvName.setText(profile.name);
                        tvPhone.setText(profile.phone);
                        tvEmail.setText(profile.email);
                        tvDOB.setText(profile.dob);
                        tvLocation.setText(profile.location);
                        tvState.setText(profile.state);
                        tvCrisisType.setText(profile.crisisType);
                        tvRecoveryStage.setText(profile.recoveryStage);
                        tvOccupation.setText(profile.occupation);
                        tvMedicalNeeds.setText(profile.medicalNeeds);
                        tvGender.setText(profile.gender);
                        tvUrgentHelp.setText(profile.urgentHelp ? "Yes" : "No");
                    }
                } else {
                    Toast.makeText(ProfileActivity.this, "Profile not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Error loading profile", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
