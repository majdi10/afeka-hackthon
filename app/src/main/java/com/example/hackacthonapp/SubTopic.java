package com.example.hackacthonapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SubTopic extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    private Button finishBtn;
    private EditText mEdit;
    private int countRow =0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_topic);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        finishBtn = (Button)findViewById(R.id.finish_button);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onAddField(View v) {

//        mEdit   = (EditText)findViewById(R.id.number_edit_text);
//        System.out.println(mEdit.getText().toString());

//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final View rowView = inflater.inflate(R.layout.field, null);



//         Add the new row before the add field button.
//        if(countRow < 3){
//            parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
//            countRow++;
//        }else{
//            System.out.println("maximun count");
//        }


    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
        countRow--;
    }

    public void finish(){
        Intent intent = new Intent(SubTopic.this, Lesson.class);
        startActivity(intent);
    }
}

