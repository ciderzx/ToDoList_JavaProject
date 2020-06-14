package com.example.todolist_javaproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollActivity  extends AppCompatActivity {

    public Button add_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        add_view = findViewById(R.id.add_layout);

        add_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SubList n_layout = new SubList(getApplicationContext());
                LinearLayout con = (LinearLayout)findViewById(R.id.con);
                con.addView(n_layout);
            }
        });
    }
}