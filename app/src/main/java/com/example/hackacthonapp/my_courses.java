package com.example.hackacthonapp;

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

import com.example.hackacthonapp.ui.EasyRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class my_courses extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

        System.out.println("started: my courses");

        EasyRecyclerView<String> ez_rv = new EasyRecyclerView<String>(this, new EasyRecyclerView.CellsFactory<String>() {
            @Override
            public EasyRecyclerView.CellHolder<String> create(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_cell, null);
                return new Cell(view);
            }
        });


        LinearLayout lr1 = findViewById(R.id.linear_layout1);
        lr1.addView(ez_rv, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        final ArrayList<String> list = new ArrayList<>();
        Arrays.stream(mobileArray).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                list.add(s);
            }
        });

        ez_rv.setData(list);
    }

    public void add_list() {


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
                }
            });
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
