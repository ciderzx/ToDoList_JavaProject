package com.example.todolist_javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    }

    public void mOnPopupClick(View v){

        if(ispopup){
            Intent intent = new Intent(this, PopupActivity.class);
            startActivityForResult(intent, 1);
            ispopup = false;
        }
        else{
            SubList n_layout = new SubList(getApplicationContext());
            LinearLayout con = (LinearLayout)findViewById(R.id.con);
            con.addView(n_layout);
            ispopup = true;
        }
    }

}