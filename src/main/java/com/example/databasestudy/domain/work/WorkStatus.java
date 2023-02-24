package com.example.databasestudy.domain.work;

public enum WorkStatus {
    BEFORE("작업전"),
    PROGRESS("진행중"),
    COMPLETE("작업완료");

    final private String status;

    public String getStatus() {
        return status;
    }

    WorkStatus(String status) {
        this.status = status;
    }

}
