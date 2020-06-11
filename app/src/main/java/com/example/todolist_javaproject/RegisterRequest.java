package com.example.todolist_javaproject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 url 설정(php파일 연동)
    final static  private String URL="http://ciderxx.dothome.co.kr/Register.php";
    private Map<String,String>map;

    public RegisterRequest(String userLoginId, String userPassword, String userName, String userCompanyName,Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);//위 url에 post방식으로 값을 전송

        map=new HashMap<>();
        map.put("userLoginId",userLoginId);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userCompanyName",userCompanyName);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}