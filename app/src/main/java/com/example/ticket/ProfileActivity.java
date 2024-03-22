package com.example.ticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUsername, txtEmail;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtUseremail);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        txtEmail.setText(SharedPrefManager.getInstance(this).getEmail());
        txtUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        getTask();
    }

    private void getTask() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    System.out.println(object.getInt("id"));
                    if (!object.getBoolean("error")) {


                    } else {
                        Toast.makeText(getApplicationContext(), "message", Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }

        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();


                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    @Override
    public void onClick(View v) {
        if (v == btnLogout) {
            SharedPrefManager.getInstance(this).logout();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
}

