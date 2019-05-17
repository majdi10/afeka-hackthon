package com.example.hackacthonapp.OOPs;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CourseJsonModel {

    @SerializedName("courseslist")
    @Expose
    private List<CourseItem> courseslist = null;

    public List<CourseItem> getCourseslist() {
        return courseslist;
    }

    public void setCourseslist(List<CourseItem> courseslist) {
        this.courseslist = courseslist;
    }

}