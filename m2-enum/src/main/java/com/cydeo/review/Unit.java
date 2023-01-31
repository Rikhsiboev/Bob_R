package com.cydeo.review;

public enum Unit {

    PCS("pieces"), POUNDS("pounds"), INCHES("inches"), MILES("miles");

    public String value;

    Unit(String value) {
        this.value = value;
    }

}
