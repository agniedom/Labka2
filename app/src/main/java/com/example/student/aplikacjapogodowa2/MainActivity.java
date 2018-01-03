package com.example.student.aplikacjapogodowa2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Button btn2 = findViewById(R.id.btn_pokaz_liste_dostepnych_miejsc);

        Button btn1 = findViewById(R.id.btn_zmien_miejsce);


        final EditText editText = findViewById(R.id.txt_edittext);
        final TextView miasto = findViewById(R.id.txt_miasto);
        
        btn2.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }


        });
        btn1.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                String g = editText.getText().toString();
                miasto.setText(g);
                Bundle bundle = new Bundle();
                bundle.putString("item", g);
                intent.putExtras(bundle);

            }


        });
    }}
