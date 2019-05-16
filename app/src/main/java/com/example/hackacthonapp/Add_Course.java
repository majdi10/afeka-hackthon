package com.example.hackacthonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Course extends AppCompatActivity {
    private EditText courseIdEt;
    private EditText courseNameEt;
    private EditText institueNameEt;
    private EditText lecturerIdEt;
    private Button addCourseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__course);

        courseIdEt = (EditText)findViewById(R.id.course_code_text);
        courseNameEt = (EditText)findViewById(R.id.name_text);
        institueNameEt = (EditText)findViewById(R.id.institue_text);
        lecturerIdEt = (EditText)findViewById(R.id.ID_text);
        addCourseBtn = (Button)findViewById(R.id.add_course);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
