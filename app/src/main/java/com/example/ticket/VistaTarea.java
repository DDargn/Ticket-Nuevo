package com.example.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class VistaTarea extends AppCompatActivity {
    String data[]=new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_tarea);
        Bundle extras = getIntent().getExtras();
        data=extras.getStringArray("Data");
        System.out.println(data);
    }
}