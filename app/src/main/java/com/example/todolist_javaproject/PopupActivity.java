package com.example.todolist_javaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.json.JSONException;
import org.json.JSONObject;

public class PopupActivity extends Activity {

    public EditText mainEdit;
    public EditText dataEdit;
    public TextView main_Title;
    private Button btn_saveTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_popup);

        mainEdit = findViewById(R.id.popMainTitle);
        dataEdit = findViewById(R.id.Data);
        main_Title = findViewById(R.id.MainTitle);
        btn_saveTodo = findViewById(R.id.button1);

        btn_saveTodo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //데이터 전달하기
                Intent intent = new Intent(getApplicationContext(), SubList.class);
                Intent getIntent = getIntent();
                UserVo user = (UserVo)getIntent.getSerializableExtra("User");
                intent.putExtra("User", user);

                int userId = user.getUserId();

                CalendarDay date = new CalendarDay();
                String dateId = String.valueOf(date.getYear()) + String.valueOf(date.getMonth()+1) + String.valueOf(date.getDay());

                String maintitle = mainEdit.getText().toString();
                String data = dataEdit.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>() {//volley
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject=new JSONObject(response);//Register2 php에 response
                            boolean success=jasonObject.getBoolean("success");//Register2 php에 sucess
                            if (success) {//일정 생성 성공한 경우
                                mainEdit.setText("");
                                dataEdit.setText("");


                                Toast.makeText(getApplicationContext(), "일정 생성 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PopupActivity.this, ScrollActivity.class);
                                startActivity(intent);
                            }

                            else{//일정 생성 실패한 경우
                                Toast.makeText(getApplicationContext(),"일정 생성 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로 volley를 이용해서 요청을 함
                PopupRequest popupRequest =new PopupRequest(dateId, userId, maintitle, data, responseListener);
                RequestQueue queue= Volley.newRequestQueue(PopupActivity.this);
                queue.add(popupRequest);

            }
        });
    }


    //닫기 버튼 클릭
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