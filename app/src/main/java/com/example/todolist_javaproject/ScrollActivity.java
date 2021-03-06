package com.example.todolist_javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollActivity  extends AppCompatActivity {

    public Button add_view;
    public TextView main_Title;

    private boolean ispopup = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        add_view = findViewById(R.id.add_layout);
        main_Title = findViewById(R.id.MainTitle);

        if(ispopup){

            SubList n_layout = new SubList(getApplicationContext());
            LinearLayout con = (LinearLayout)findViewById(R.id.con);
            con.addView(n_layout);
        }

        else{

            SubList n_layout = new SubList(getApplicationContext());
            LinearLayout con = (LinearLayout)findViewById(R.id.con);
            con.addView(n_layout);
        }


    }


    public void mOnPopupClick(View v){
        Intent intent = new Intent(this, PopupActivity.class);
        Intent getIntent = getIntent();
        UserVo user = (UserVo)getIntent.getSerializableExtra("User");
        System.out.println(user.getUserId());
        intent.putExtra("User", user);
        startActivityForResult(intent, 1);
        ispopup = false;
    }
}