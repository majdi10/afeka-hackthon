package com.example.hackacthonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lesson extends AppCompatActivity {

    private Button startBtn;
    private Button staticsBtn;
    private Button subTopicBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        startBtn = (Button)findViewById(R.id.startLessonBtn);
        staticsBtn = (Button)findViewById(R.id.showStaticsBtn);
        subTopicBtn = (Button)findViewById(R.id.subTopicsBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        staticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        subTopicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson.this, SubTopic.class);
                startActivity(intent);
            }
        });

    }
}
