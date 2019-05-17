package com.example.hackacthonapp.OOPs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseItem {

    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("academicCode")
    @Expose
    private String academicCode;
    @SerializedName("institute")
    @Expose
    private String institute;
    @SerializedName("lid")
    @Expose
    private String lid;
    @SerializedName("details")
    @Expose
    private String details;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicCode() {
        return academicCode;
    }

    public void setAcademicCode(String academicCode) {
        this.academicCode = academicCode;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}