package com.example.ticket;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class taskWindow extends Fragment {
    public static final String TITLE = "title";
    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_window, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.rv);
        ((TextView)view.findViewById(R.id.textView)).setText(getArguments().getString(TITLE));
        context=getActivity();
        switch(((TextView)view.findViewById(R.id.textView)).getText().toString()){
            case "1":

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASK, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        int fk_iduser=0;
                        try {
                            if(response.equals("[]")){

                            }else{
                                JSONObject object = new JSONObject(response);

                                JSONArray tasksArray = object.getJSONArray("Tasks");



                                if (tasksArray!=null) {
                                    ArrayList<Task> tareas = null;
                                    tareas = new ArrayList<>();
                                    for (int i = 0; i < tasksArray.length(); i++) {

                                        JSONObject taskObject = tasksArray.getJSONObject(i);
                                        Task task = new Task(taskObject.getInt("fk_iduser"), taskObject.getString("title"), taskObject.getString("text"));

                                        tareas.add(task);

                                    }
                                    System.out.println(tareas);
                                    TaskAdapter adapter = new TaskAdapter(context, tareas);
                                    rv.setAdapter(adapter);
                                    rv.setLayoutManager(new LinearLayoutManager(context));
                                } else {
                                    Toast.makeText(context, "message", Toast.LENGTH_LONG).show();

                                }
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();

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
                RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                break;

            case "2":
                Integer fk_iduser = SharedPrefManager.getInstance(context).getId();
                String fk_iduser1=fk_iduser.toString();
                stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASKASSIGNED, new Response.Listener<String>() {
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
                                    TaskAdapter adapter = new TaskAdapter(context, tareas);
                                    rv.setAdapter(adapter);
                                    rv.setLayoutManager(new LinearLayoutManager(context));
                                } else {
                                    Toast.makeText(context, "message", Toast.LENGTH_LONG).show();

                                }
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();

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
                RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                break;
            case "3":
                fk_iduser = SharedPrefManager.getInstance(context).getId();
                fk_iduser1=fk_iduser.toString();
                stringRequest = new StringRequest(Request.Method.POST, Constants.URL_TASKACCEPTED, new Response.Listener<String>() {
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
                                    TaskAdapter adapter = new TaskAdapter(context, tareas);
                                    rv.setAdapter(adapter);
                                    rv.setLayoutManager(new LinearLayoutManager(context));
                                } else {
                                    Toast.makeText(context, "message", Toast.LENGTH_LONG).show();

                                }
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();

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
                RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                break;

            }

        }

        //RELLENAR EL RV CON DATOS DESDE VPADAPTER
    }

