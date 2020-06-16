package com.example.todolist_javaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PopupActivity extends Activity {

    public EditText mainEdit;
    public EditText dataEdit;
    public TextView main_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_popup);

        mainEdit = findViewById(R.id.popMainTitle);
        dataEdit = findViewById(R.id.Data);
        main_Title = findViewById(R.id.MainTitle);

    }

    public void mOnSave(View v) {
        //데이터 전달하기
        Intent intent = new Intent(getApplicationContext(), SubList.class);

        String maintitle = mainEdit.getText().toString();
        String data = dataEdit.getText().toString();

        intent.putExtra("main", maintitle);
        intent.putExtra("data", data);

        finish();

    }

    //확인 버튼 클릭
    public void mOnClose(View v) {
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}