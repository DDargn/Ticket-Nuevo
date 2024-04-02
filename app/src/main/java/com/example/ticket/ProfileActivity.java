package com.example.ticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.List;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUsername, txtEmail;
    private Button btnLogout;

    private RecyclerView rv, rvAs, rvA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        rv=findViewById(R.id.rvToDo);
        rvAs=findViewById(R.id.rvSet);
        rvA=findViewById(R.id.rvAccept);

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
        getTask(); //Este metodo debera recoger todas las tareas cuya clave foranea sea igual a 6 (que es la del admin);
        //getTaskAssigned() Metodo que debera recoger todas las tareas asignadas al usuario que se encuentre logeado.
        //getTaskAccepted() Metodo que debera recoger todas las tareas cuyo campo aceptado sea igual a 2 y que pertenezcan al usuario logeado.
        //rellenarRecyclerView() Metodo que debera rellenar los 3 recyclerView con los datos obtenidos en los tres metodos anteriores.
    }

    private void getTask() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASK, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int fk_iduser=0;
                try {
                    JSONObject object = new JSONObject(response);
                    System.out.println(object);
                    JSONArray tasksArray = object.getJSONArray("Tasks");
                    for (int i = 0; i < tasksArray.length(); i++) {
                        // Obtener el objeto JSON actual
                        JSONObject taskObject = tasksArray.getJSONObject(i);

                        //comprobar que son task con el fk_user=6
                        fk_iduser = taskObject.getInt("fk_iduser");


                    }
                    if (fk_iduser==6) {
                        ArrayList<Task> tareas = null;
                        for (int i = 0; i < tasksArray.length(); i++) {
                            tareas = new ArrayList<>();
                            JSONObject taskObject = tasksArray.getJSONObject(i);
                            Task task = new Task(taskObject.getInt("fk_iduser"), taskObject.getString("title"), taskObject.getString("text"));
                            System.out.println(task.toString());
                            tareas.add(task);
                            System.out.println(tareas);
                        }
                        //rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        rv.setAdapter(new TaskAdapter(tareas));
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

