package com.example.todolist_javaproject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 url 설정(php파일 연동)
    final static  private String URL="http://ciderxx.dothome.co.kr/Login.php";
    private Map<String,String>map;

    public LoginRequest(String userLoginId, String userPassword, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("userLoginId",userLoginId);
        map.put("userPassword",userPassword);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
