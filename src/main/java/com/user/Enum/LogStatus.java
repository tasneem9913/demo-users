package com.user.Enum;

public enum LogStatus {

    STARTED("STARTED"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    ERROR("ERROR");

    private String status;

    LogStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

}
