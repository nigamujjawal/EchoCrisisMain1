package com.uj.echocrisismain;

public class UserProfile {
    public String name, phone, email, dob, gender, location, state,
            crisisType, recoveryStage, occupation, medicalNeeds;
    public boolean urgentHelp;

    public UserProfile() {}  // Required for Firebase

    public UserProfile(String name, String phone, String email, String dob, String gender,
                       String location, String state, String crisisType, String recoveryStage,
                       String occupation, String medicalNeeds, boolean urgentHelp) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.location = location;
        this.state = state;
        this.crisisType = crisisType;
        this.recoveryStage = recoveryStage;
        this.occupation = occupation;
        this.medicalNeeds = medicalNeeds;
        this.urgentHelp = urgentHelp;
    }
}
