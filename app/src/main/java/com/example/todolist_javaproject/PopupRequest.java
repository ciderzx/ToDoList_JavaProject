package com.example.todolist_javaproject;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PopupRequest extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://ciderxx.dothome.co.kr/InsertTodo.php";
    private HashMap<String, String> map;

    public PopupRequest(String dateId, int userId, String todoTitle, String todoData, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);//위 url에 post방식으로 값을 전송

        map=new HashMap<String, String>();
        map.put("dateId", dateId);
        map.put("userId", String.valueOf(userId));
        map.put("todoTitle",todoTitle);
        map.put("todoData",todoData);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
