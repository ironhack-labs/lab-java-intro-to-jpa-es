package org.ironhack.w7lab.model;

public enum CustomerStatus {
    GOLD("Gold"),
    SILVER("Silver"),
    NONE("None");

    private final String displayName;

    CustomerStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
