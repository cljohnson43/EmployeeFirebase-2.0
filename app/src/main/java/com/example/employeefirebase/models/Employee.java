package com.example.employeefirebase.models;

public class Employee {
    private String mName;
    private String mCompany;
    private String mId;

    public Employee(String mName, String mCompany) {
        this.mName = mName;
        this.mCompany = mCompany;
    }

    public Employee() {}

    public Employee(String mName) {
        this.mName = mName;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
}
