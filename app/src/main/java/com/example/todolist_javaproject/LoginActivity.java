package com.example.todolist_javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText et_id, et_pass;
    private Button btn_login,btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {//회원가입 버튼을 클릭시 수행
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userLoginId=et_id.getText().toString();
                String userPass=et_pass.getText().toString();


                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jasonObject=new JSONObject(response);
                            boolean success=jasonObject.getBoolean("success");
                            if (success) {//로그인 성공한 경우
                                String userLoginId = jasonObject.getString("loginId");
                                String userPass = jasonObject.getString("password");
                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, CalendarActivity.class);
                                intent.putExtra("log", "User");
                                intent.putExtra("loginId", userLoginId);

                                UserVo user = new UserVo();
                                user.setUserId(Integer.parseInt(jasonObject.getString("userId")));
                                user.setUserName(jasonObject.getString("userName"));
                                user.setCompanyName(jasonObject.getString("companyName"));
                                user.setCompleteCnt(Integer.parseInt(jasonObject.getString("completeCnt")));
                                user.setTodoCnt(Integer.parseInt(jasonObject.getString("todoCnt")));

                                intent.putExtra("User", user);
                                startActivity(intent);
                            }


                            else{//로그인 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest=new LoginRequest(userLoginId,userPass,responseListener);
                RequestQueue queue= Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}