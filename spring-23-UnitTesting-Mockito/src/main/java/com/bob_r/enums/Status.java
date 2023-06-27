package com.bob_r.enums;

public enum Status {

    OPEN("Open"),IN_PROGRESS("In Progress"),COMPLETE("Completed");

    private final String value;

    public String getValue() {
        return value;
    }

    Status(String value) {
        this.value = value;
    }

}