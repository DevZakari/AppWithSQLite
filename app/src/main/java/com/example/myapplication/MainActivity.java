package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_insert;
    EditText tv_nom;
    EditText tv_prenom;

    MyDatabase myDB;
    ArrayList<String> person_id,person_f_name,person_l_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_insert = findViewById(R.id.btn_Insert);
        tv_nom = findViewById(R.id.tv_nom);
        tv_prenom = findViewById(R.id.tv_prenom);



        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv_nom.getText().toString().isEmpty() || tv_prenom.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter the fields !!", Toast.LENGTH_SHORT).show();

                } else {
                    MyDatabase myDB = new MyDatabase(MainActivity.this);
                    myDB.addPerson(tv_prenom.getText().toString().trim(),tv_nom.getText().toString().trim());

                }
            }
        });

    }


}