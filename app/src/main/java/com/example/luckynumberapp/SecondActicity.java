package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActicity extends AppCompatActivity {
    TextView luckyNumber_text,welcome_text;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_acticity);
        luckyNumber_text=findViewById(R.id.textView3);
        welcome_text=findViewById(R.id.textView2);
        share_btn=findViewById(R.id.button);
        //Receiving the data from main Activity
        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        int random_num=generateRandomNumber();
        luckyNumber_text.setText(""+random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(userName,random_num);
            }
        });


    }
    //Generating random Numbers
    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
    int randomNumberGenerated=random.nextInt(upper_limit);
    return randomNumberGenerated;

    }
    public void sharedata(String userName,int random_num){
        //implicit intent
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //Additional info
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His Lucky Number is "+random_num);
        startActivity(Intent.createChooser(i,"Choose a Platform "));
    }
}