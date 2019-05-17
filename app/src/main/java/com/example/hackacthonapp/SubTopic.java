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

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);


//         Add the new row before the add field button.
        if(countRow < 3){
            parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
            countRow++;
        }else{
            System.out.println("maximun count");
        }


    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
        countRow--;
    }

    public void finish(){
//        Context c;
//        List<String> q = new ArrayList<>();
//        for (int i = 0; i< parentLinearLayout.getChildCount();i++)
//        {
//            c = parentLinearLayout.getChildAt(i).;
//        }
        List<String> ques = new ArrayList<>();
        ArrayList<EditText> myEditTextList = new ArrayList<>();
        for (int i = 0;i<parentLinearLayout.getChildCount();i++)
        {
            if( parentLinearLayout.getChildAt( i ) instanceof LinearLayout )
            {
                LinearLayout cur = (LinearLayout)parentLinearLayout.getChildAt( i );
                for (int j=0;j<cur.getChildCount();j++){
                    if(cur.getChildAt(j) instanceof EditText)
                    {
                        myEditTextList.add((EditText)cur.getChildAt(j));
                    }
                }
            }
        }

        for (EditText e:myEditTextList) {
            if(!e.getText().toString().equals(""))
                ques.add(e.getText().toString().toLowerCase());
        }
        Intent intent = new Intent(SubTopic.this, Lesson.class);
        startActivity(intent);
    }
}

