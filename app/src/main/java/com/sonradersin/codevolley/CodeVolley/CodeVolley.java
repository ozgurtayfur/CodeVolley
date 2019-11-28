package com.sonradersin.codevolley.CodeVolley;

import android.content.Context;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CodeVolley {

    private Context CONTEXT;
    private Map<String,String> PARAMS = new HashMap<String, String>();

    public CodeVolley(Context _CONTEXT){
        this.CONTEXT = _CONTEXT;
    }
    
    public void AddValue(String key,String value){
        this.PARAMS.put(key,value);
    }

    public Map<String, String> getPARAMS() {
        return PARAMS;
    }

    public void Request(Integer R_METHOD, String R_URL, final Map<String,String> R_PARAMS, final CVCallback callback){
        
        StringRequest stringRequest = new StringRequest(R_METHOD, R_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERROR_VOLLEY",error.toString());
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                return R_PARAMS;
            }
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {

                String strUTF8 = null;
                try {
                    strUTF8 = new String(response.data, "UTF-8");

                } catch (UnsupportedEncodingException e) {

                    e.printStackTrace();
                }
                return Response.success(strUTF8,
                        HttpHeaderParser.parseCacheHeaders(response));
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this.CONTEXT);
        requestQueue.add(stringRequest);
        
    }

}
