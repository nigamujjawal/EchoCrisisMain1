package com.uj.echocrisismain;

import java.util.HashMap;
import java.util.Map;

public class EmergencyContact {
    private String name;
    private String phone;
    private String relationship;

    // Required empty constructor (for Firestore deserialization)
    public EmergencyContact() {}

    public EmergencyContact(String name, String phone, String relationship) {
        this.name = name;
        this.phone = phone;
        this.relationship = relationship;
    }

    // Convert to Map for Firestore
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", name != null ? name : "");
        map.put("phone", phone != null ? phone : "");
        map.put("relationship", relationship != null ? relationship : "");
        return map;
    }

    // Convert from Map (retrieved from Firestore)
    public static EmergencyContact fromMap(Map<String, String> map) {
        EmergencyContact contact = new EmergencyContact();
        contact.name = map.getOrDefault("name", "");
        contact.phone = map.getOrDefault("phone", "");
        contact.relationship = map.getOrDefault("relationship", "");
        return contact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }
}
