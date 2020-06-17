package com.example.todolist_javaproject;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SubListRequest extends StringRequest {

    final static  private String URL="http://ciderxx.dothome.co.kr/GetSelectTodoList.php";
    private Map<String,String> map;

    public SubListRequest(int userId, String dateId, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("userId",String.valueOf(userId));
        map.put("dateId",dateId);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
