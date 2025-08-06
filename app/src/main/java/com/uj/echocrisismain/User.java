package com.uj.echocrisismain;

import com.google.firebase.firestore.DocumentSnapshot;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String location;
    private String state;
    private String crisisType;
    private String recoveryStage;
    private Date createdAt;
    private List<EmergencyContact> emergencyContacts;
    private String profileImageUrl;

    public User() {
        // Required empty constructor for Firestore
        this.emergencyContacts = new ArrayList<>();
        this.createdAt = new Date();
    }

    public User(String userId, String name, String email) {
        this();
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public User(String userId, String name, String email, String phone, String location, String state,
                String crisisType, String recoveryStage, String profileImageUrl) {
        this();
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.state = state;
        this.crisisType = crisisType;
        this.recoveryStage = recoveryStage;
        this.profileImageUrl = profileImageUrl;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("name", name);
        map.put("email", email);
        map.put("phone", phone);
        map.put("location", location);
        map.put("state", state);
        map.put("crisisType", crisisType);
        map.put("recoveryStage", recoveryStage);
        map.put("createdAt", createdAt);
        map.put("profileImageUrl", profileImageUrl);

        List<Map<String, String>> contactsList = new ArrayList<>();
        if (emergencyContacts != null) {
            for (EmergencyContact contact : emergencyContacts) {
                contactsList.add(contact.toMap());
            }
        }
        map.put("emergencyContacts", contactsList);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static User fromDocument(DocumentSnapshot doc) {
        User user = new User();
        user.userId = doc.getString("userId");
        user.name = doc.getString("name");
        user.email = doc.getString("email");
        user.phone = doc.getString("phone");
        user.location = doc.getString("location");
        user.state = doc.getString("state");
        user.crisisType = doc.getString("crisisType");
        user.recoveryStage = doc.getString("recoveryStage");
        user.createdAt = doc.getDate("createdAt") != null ? doc.getDate("createdAt") : new Date();
        user.profileImageUrl = doc.getString("profileImageUrl");

        List<Map<String, String>> contactsList = (List<Map<String, String>>) doc.get("emergencyContacts");
        user.emergencyContacts = new ArrayList<>();

        if (contactsList != null) {
            for (Map<String, String> contactMap : contactsList) {
                user.emergencyContacts.add(EmergencyContact.fromMap(contactMap));
            }
        }

        return user;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCrisisType() { return crisisType; }
    public void setCrisisType(String crisisType) { this.crisisType = crisisType; }

    public String getRecoveryStage() { return recoveryStage; }
    public void setRecoveryStage(String recoveryStage) { this.recoveryStage = recoveryStage; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public List<EmergencyContact> getEmergencyContacts() { return emergencyContacts; }
    public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) { this.emergencyContacts = emergencyContacts; }

    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
}
