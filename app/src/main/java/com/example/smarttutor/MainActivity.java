package com.example.smarttutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button findTutor;
    Button tutor;
    Context mContext = MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findTutor = findViewById(R.id.looking_for_a_tutor_button);
        tutor = findViewById(R.id.i_am_a_tutor_button);

        findTutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TutorActivity.class);
                startActivity(intent);
            }
        });
    }
}