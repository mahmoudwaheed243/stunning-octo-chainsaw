package com.example.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class alculatro extends AppCompatActivity {
    Button go;
    EditText editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alculatro);
        editText1 = findViewById(R.id.edittext1);

        go =findViewById(R.id.buttomgo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //u were needed this initialization for s in the first
                //anshaa allah it will wrok now XD
                //if not tell me plz
                //moah
                int s=6;
                s = Integer.parseInt(editText1.getText().toString());
                Intent in= new Intent(getApplicationContext() , Gpatable.class);
                in.putExtra("no",s);
                startActivity(in);
            }
        });

    }
}