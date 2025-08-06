package com.uj.echocrisismain;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ProfileSetupActivity extends AppCompatActivity {

    EditText etName, etPhone, etEmail, etDOB, etLocation, etState,
            etCrisisType, etRecoveryStage, etOccupation, etMedicalNeeds;
    Spinner spinnerGender;
    CheckBox checkUrgentHelp;
    Button btnSaveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        // Initialize Views
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etDOB = findViewById(R.id.etDOB);
        etLocation = findViewById(R.id.etLocation);
        etState = findViewById(R.id.etState);
        etCrisisType = findViewById(R.id.etCrisisType);
        etRecoveryStage = findViewById(R.id.etRecoveryStage);
        etOccupation = findViewById(R.id.etOccupation);
        etMedicalNeeds = findViewById(R.id.etMedicalNeeds);
        spinnerGender = findViewById(R.id.spinnerGender);
        checkUrgentHelp = findViewById(R.id.checkUrgentHelp);
        btnSaveProfile = findViewById(R.id.btnSaveProfile);

        // Set Gender Options
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(genderAdapter);

        // Date Picker
        etDOB.setOnClickListener(v -> showDatePicker());

        // Save Profile
        btnSaveProfile.setOnClickListener(v -> saveProfileData());
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    etDOB.setText(date);
                }, year, month, day);
        datePickerDialog.show();
    }

    private void saveProfileData() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser == null) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show();
            return;
        }

        String uid = firebaseUser.getUid();

        UserProfile profile = new UserProfile(
                etName.getText().toString(),
                etPhone.getText().toString(),
                etEmail.getText().toString(),
                etDOB.getText().toString(),
                spinnerGender.getSelectedItem().toString(),
                etLocation.getText().toString(),
                etState.getText().toString(),
                etCrisisType.getText().toString(),
                etRecoveryStage.getText().toString(),
                etOccupation.getText().toString(),
                etMedicalNeeds.getText().toString(),
                checkUrgentHelp.isChecked()
        );

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");
        ref.child(uid).setValue(profile)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show();

                    // 🔁 Go to DashboardActivity (with 4 buttons)
                    Intent intent = new Intent(ProfileSetupActivity.this, DashboardActivity.class);
                    intent.putExtra("username", profile.name); // optional welcome message
                    startActivity(intent);
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to save profile: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
