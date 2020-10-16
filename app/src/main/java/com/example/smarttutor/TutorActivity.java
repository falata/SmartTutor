package com.example.smarttutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smarttutor.model.TutorInfo;

import java.util.ArrayList;
import java.util.List;

public class TutorActivity extends AppCompatActivity {

    public TutorInfoAdapter mAdapter;
    private DataViewModel mDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(notesLayoutManager);
        mAdapter = new TutorInfoAdapter(this);
        recyclerView.setAdapter(mAdapter);
        mDataViewModel= new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(DataViewModel.class);
        mDataViewModel.tutorInfoMutableData.observe(this, new Observer<List<TutorInfo>>() {
            @Override
            public void onChanged(List<TutorInfo> tutorInfos) {
                mAdapter.setList(tutorInfos);
            }
        });

    }
}