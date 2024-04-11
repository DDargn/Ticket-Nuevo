package com.example.ticket;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }





        /*getTask();
        getTaskAssigned();
        getTaskAccepted();
    */


        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewpager2);

        VPAdapter adapter = new VPAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(""+(position+1));

            }
        }).attach();


    }

    @Override
    public void onClick(View v) {

    }

    /*



    private void getTaskAssigned() {
        final Integer fk_iduser = SharedPrefManager.getInstance(getApplicationContext()).getId();
        String fk_iduser1=fk_iduser.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASKASSIGNED, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    if(response.equals("[]")){

                    }else {
                        JSONObject object = new JSONObject(response);

                        JSONArray tasksArray = object.getJSONArray("Tasks");

                        if (tasksArray != null) {
                            ArrayList<Task> tareas = null;
                            tareas = new ArrayList<>();
                            for (int i = 0; i < tasksArray.length(); i++) {

                                JSONObject taskObject = tasksArray.getJSONObject(i);
                                Task task = new Task(taskObject.getInt("fk_iduser"), taskObject.getString("title"), taskObject.getString("text"));

                                tareas.add(task);

                            }
                            System.out.println(tareas);
                            TaskAdapter adapter = new TaskAdapter(getApplicationContext(), tareas);
                            rvAs.setAdapter(adapter);
                            rvAs.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        } else {
                            Toast.makeText(getApplicationContext(), "message", Toast.LENGTH_LONG).show();

                        }
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

                params.put("fk_iduser", fk_iduser1);

                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void getTaskAccepted() {
        final Integer fk_iduser = SharedPrefManager.getInstance(getApplicationContext()).getId();
        String fk_iduser1=fk_iduser.toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASKACCEPTED, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    if(response.equals("[]")){

                    }else {
                        JSONObject object = new JSONObject(response);

                        JSONArray tasksArray = object.getJSONArray("Tasks");

                        if (tasksArray != null) {
                            ArrayList<Task> tareas = null;
                            tareas = new ArrayList<>();
                            for (int i = 0; i < tasksArray.length(); i++) {

                                JSONObject taskObject = tasksArray.getJSONObject(i);
                                Task task = new Task(taskObject.getInt("fk_iduser"), taskObject.getString("title"), taskObject.getString("text"));

                                tareas.add(task);

                            }
                            System.out.println(tareas);
                            TaskAdapter adapter = new TaskAdapter(getApplicationContext(), tareas);
                            rvA.setAdapter(adapter);
                            rvA.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        } else {
                            Toast.makeText(getApplicationContext(), "message", Toast.LENGTH_LONG).show();

                        }
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

                params.put("fk_iduser", fk_iduser1);

                return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }

*/
}

