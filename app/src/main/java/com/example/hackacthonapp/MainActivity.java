package com.example.hackacthonapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hackacthonapp.OOPs.Static_Variables;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private EditText userNameEt;
    private EditText passwordEt;
    private TextView errorMassageTv;
    private Button loginBtn;
//hii
    //elitest
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userNameEt = (EditText)findViewById(R.id.userNameEditText);
        passwordEt = (EditText)findViewById(R.id.passwordEditText);
        errorMassageTv = (TextView)findViewById(R.id.errorTextView);
        loginBtn = (Button)findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                errorMassageTv.setText("");
                checkingPassword(userNameEt.getText().toString(), passwordEt.getText().toString());
            }
        });

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Add_Course.class);
                startActivity(intent);
            }
        });
    }

    private void checkingPassword(String userName, String password){
        OkHttpClient client = new OkHttpClient();

        String url = Static_Variables.url +  "/lecturer/login?username="+userName+",password="+password;
        Request request = new Request.Builder().url(url).build();
        System.out.println(request.toString());
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                System.out.println(res);

                if(!res.equals("") && res.charAt(0) !=  '0'){
                    Intent intent = new Intent(MainActivity.this, my_courses.class);

                    Bundle b = new Bundle();
                    b.putString("LID", res); //my id
                    intent.putExtras(b); //LID to next activity

                    startActivity(intent);
                }
                else{
                    errorMassageTv.setText("UserName or password is wrong");
                }
            }
        });

//        if(userName.equals("r") && password.equals("1")){
//            Intent intent = new Intent(MainActivity.this, my_courses.class);
//            startActivity(intent);
//        }
//        else{
//            errorMassageTv.setText("UserName or password is wrong");
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
