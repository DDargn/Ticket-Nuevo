package com.example.ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class VistaTarea extends AppCompatActivity {
    String data[]=new String[2];
    Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_tarea);
        data=intent.getStringArrayExtra("Data");
        System.out.println(data);
    }
}