package com.example.smarttutor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smarttutor.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.findTutorsButton) Button mFindTutorsButton;
    @BindView(R.id.becomeTutor)  Button mBecomeTutor;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindTutorsButton.setOnClickListener(this);
        mBecomeTutor.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v == mFindTutorsButton) {
            Intent intent = new Intent(MainActivity.this, TutorActivity.class);
            startActivity(intent);
        }
        if (v == mBecomeTutor) {
            Intent intent = new Intent(MainActivity.this, TutorFormActivity.class);
            startActivity(intent);
        }

        }
    }
