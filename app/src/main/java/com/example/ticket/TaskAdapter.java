package com.example.ticket;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder>{
    Context context;
    private ArrayList<Task> tasks; // Assuming you have a list of Task objects

    private String data[]= new String[4];
    private String pos;

    public void setPos(String pos) {
        this.pos = pos;
    }

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context= context.getApplicationContext();
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklist, parent, false);
        return new TaskAdapter.TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskAdapter.TaskHolder holder, int position) {
        Task task = tasks.get(position);
        holder.titulo.setText(task.getTitle());
        holder.descripcion.setText(task.getText());
        holder.date.setText(task.getDate());
        Log.d("error", task.getTitle());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder { // Define the ViewHolder as an inner class

        TextView titulo,date;
        EditText descripcion;

        RadioButton rb;


        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitle);
            descripcion = itemView.findViewById(R.id.txtContext);
            date = itemView.findViewById(R.id.txtDate);
            rb = itemView.findViewById(R.id.radioButton);

            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data[0]=titulo.getText().toString();
                    data[1]=descripcion.getText().toString();
                    data[2]=pos;
                    data[3]=date.getText().toString();

                        switch (data[2]){
                            case "1":
                                accept();

                                Intent intent = new Intent(context,ProfileActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                                break;

                            case "2":

                                complete();
                                intent = new Intent(context,ProfileActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                                break;

                            case "3":

                                negate();
                                intent = new Intent(context,ProfileActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                                break;
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
                            final String fk_iduser = Integer.toString(SharedPrefManager.getInstance(context).getId());

                            Map<String, String> params = new HashMap<>();
                            params.put("title", data[0]);
                            params.put("id", fk_iduser);

                            return params;
                        }
                    };

                    RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
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

                    RequestHandler.getInstance(context).addToRequestQueue(stringRequest);

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

                    RequestHandler.getInstance(context).addToRequestQueue(stringRequest);
                }

            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("holamundo");

                    data[0]=titulo.getText().toString();
                    data[1]=descripcion.getText().toString();
                    data[2]=pos;
                    data[3]=date.getText().toString();

                    Intent intent = new Intent(context,VistaTarea.class);
                    intent.putExtra("Data",data);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);

                }
            });

        }
    }


}

