package com.sonradersin.codevolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.sonradersin.codevolley.CodeVolley.CVCallback;
import com.sonradersin.codevolley.CodeVolley.CodeVolley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CodeVolley CDN = new CodeVolley(getApplicationContext());
        CDN.Request(Request.Method.GET, "https://android.codesoftware.xyz/test", CDN.getPARAMS(), new CVCallback() {
            @Override
            public void onSuccess(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
            }
        });

    }
}
