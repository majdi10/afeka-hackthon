package com.example.hackacthonapp.OOPs;

public class Course {
    int courseId;
    String name;
    String institute;
    String details;

    public Course(int courseId, String name, String institute, String details) {
        this.courseId = courseId;
        this.name = name;
        this.institute = institute;
        this.details = details;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getInstitute() {
        return institute;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return name + "\n" + institute + "\n" + details;
    }
}
