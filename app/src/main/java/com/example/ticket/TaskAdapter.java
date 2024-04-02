package com.example.ticket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;




public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder>{

    Context context;
    private ArrayList<Task> tasks; // Assuming you have a list of Task objects

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context=context;
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
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder { // Define the ViewHolder as an inner class

        TextView titulo;
        TextView descripcion;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            descripcion = itemView.findViewById(R.id.txtContent);
        }
    }
}

