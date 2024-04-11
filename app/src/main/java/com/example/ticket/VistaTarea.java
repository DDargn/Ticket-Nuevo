package com.example.ticket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

public class VistaTarea extends AppCompatActivity implements View.OnClickListener{
    String data[]=new String[2];
    TextView txt1,txt2;

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_tarea);

        Bundle extras = getIntent().getExtras();
        data=extras.getStringArray("Data");
        txt1= findViewById(R.id.txtTitleV);
        txt2= findViewById(R.id.txtContextV);
        txt1.setText(data[0]);
        txt2.setText(data[1]);
        System.out.println(data[0]);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == btn1) {

            accept();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        } else if (v==btn2) {

            negate();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
    }



    private void accept() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_ACCEPT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("conxion realizada");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                final String fk_iduser = Integer.toString(SharedPrefManager.getInstance(getApplicationContext()).getId());

                Map<String, String> params = new HashMap<>();
                params.put("title", data[0]);
                params.put("id", fk_iduser);

                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
        finish();
        startActivity(new Intent(this, ProfileActivity.class));
    }
    private void negate() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_NEGATE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("conxion realizada");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("title", data[0]);


                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }
    private void complete() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_COMPLETE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("conxion realizada");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("title", data[0]);


                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

}