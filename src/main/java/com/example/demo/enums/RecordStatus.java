package com.example.demo.enums;

public enum RecordStatus {
    INACTIVE("inactive"), ACTIVE("active");
    //0 - inactive, 1 - active
    public final String label;

    RecordStatus(String label) {
        this.label = label;
    }
}
