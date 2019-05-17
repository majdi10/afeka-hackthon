package com.example.hackacthonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class Add_Course extends AppCompatActivity {
    private EditText courseIdEt;
    private EditText courseNameEt;
    private EditText institueNameEt;
    private Switch vote;
    private Switch attendence;
    private Button addCourseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__course);

        courseIdEt = (EditText)findViewById(R.id.course_code_text);
        courseNameEt = (EditText)findViewById(R.id.nameEt);
        institueNameEt = (EditText)findViewById(R.id.instituteET);
        addCourseBtn = (Button)findViewById(R.id.addBtn);
        vote = (Switch)findViewById(R.id.voteSwitch);
        attendence = (Switch)findViewById(R.id.attendenceSwitch);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
