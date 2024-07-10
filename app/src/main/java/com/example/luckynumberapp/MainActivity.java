package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView txt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       txt=findViewById(R.id.textView);
       editText=findViewById(R.id.editText);
       btn=findViewById(R.id.btn);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String userName=editText.getText().toString();
               //Explicit Intent
               Intent i=new Intent(
                       getApplicationContext(),
                       SecondActicity.class);
               //passing the name to second activity
               i.putExtra("name",userName);
               startActivity(i);
           }
       });

    }
}