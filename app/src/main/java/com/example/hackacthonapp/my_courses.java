package com.example.hackacthonapp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;

import com.example.hackacthonapp.OOPs.Course;
import com.example.hackacthonapp.OOPs.CourseItem;
import com.example.hackacthonapp.OOPs.CourseJsonModel;
import com.example.hackacthonapp.OOPs.Static_Variables;
import com.example.hackacthonapp.ui.EasyRecyclerView;
import com.example.hackacthonapp.ui.GridSpacingItemDecoration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class my_courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

//        final ArrayList<String> listCourse = new ArrayList<>();
//
//        synchronized(this) {
//            //grab LID from MainActivity
//            Bundle b = getIntent().getExtras();
//            String LID = ""; // or other values
//            if (b != null) {
//                LID = b.getString("LID");
//            }
//
//            OkHttpClient client = new OkHttpClient();
//
//            String url = Static_Variables.url + "/lecturer/getcourses?lid=" + LID;
//            Request request = new Request.Builder().url(url).build();
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
////                System.out.println("response: " + response.body().string());
//                    String res = response.body().string();
//
//                    Gson gson = new Gson();
//
//                    CourseJsonModel cjm = gson.fromJson(res, CourseJsonModel.class);
//
//                    for (CourseItem item : cjm.getCourseslist()) {
//                        listCourse.add((new Course(Integer.parseInt(item.getCid()), item.getName(), item.getInstitute(), item.getDetails())).toString());
//                        System.out.println("from here  " + (new Course(Integer.parseInt(item.getCid()), item.getName(), item.getInstitute(), item.getDetails())).toString());
//                    }
//
//                }
//            });
//        }
        EasyRecyclerView<String> ez_rv = new EasyRecyclerView<String>(my_courses.this, new EasyRecyclerView.CellsFactory<String>() {
            @Override
            public EasyRecyclerView.CellHolder<String> create(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_cell, null);
                return new Cell(view);
            }
        });

        LinearLayout lr1 = findViewById(R.id.linear_layout1);
        lr1.addView(ez_rv, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        Course c1 = new Course(1, "District Math", "Afeka", "Sunday & Monday");
        Course c2 = new Course(2, "C++", "TAU", "Tuesday");
        Course c3 = new Course(3, "Algorithms", "Afeka", "Sunday");
        Course c4 = new Course(4, "Data Structures", "BGU", "Friday");
        final ArrayList<String> listCourse = new ArrayList<>();
        listCourse.add(c1.toString());
        listCourse.add(c2.toString());
        listCourse.add(c3.toString());
        listCourse.add(c4.toString());

        ez_rv.setData(listCourse);



    }

    public void add_list(ArrayList<String> listCourse) {
        EasyRecyclerView<String> ez_rv = new EasyRecyclerView<String>(my_courses.this, new EasyRecyclerView.CellsFactory<String>() {
            @Override
            public EasyRecyclerView.CellHolder<String> create(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_cell, null);
                return new Cell(view);
            }
        });

        LinearLayout lr1 = findViewById(R.id.linear_layout1);
        lr1.addView(ez_rv, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        ez_rv.setData(listCourse);
    }

    private class Cell extends EasyRecyclerView.CellHolder<String> {
        private final TextView textView;

        public Cell(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(my_courses.this, Lesson.class);
                    startActivity(intent);
//                    System.out.println("IDDDD: " + v.getId());
                }
            });
            textView.setTextSize(25);
            itemView.setMinimumHeight(400);
            itemView.setBackgroundColor(Color.parseColor("#ff22ff"));
        }


        @Override
        public void configure(String data) {
            super.configure(data);
            textView.setText(data);
        }

        @Override
        public void prepareForReuse() {
            textView.setText("");
        }
    }

}
