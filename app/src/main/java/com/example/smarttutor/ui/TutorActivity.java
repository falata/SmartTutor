package com.example.smarttutor.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.smarttutor.R;
import com.example.smarttutor.adapters.TutorListAdapter;
import com.example.smarttutor.models.TutorResponse;
import com.example.smarttutor.network.TutorApi;
import com.example.smarttutor.network.TutorClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TutorActivity extends AppCompatActivity {

    public static final String TAG = TutorActivity.class.getSimpleName();

    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private TutorListAdapter mAdapter;
    public List<TutorResponse> tutors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
        ButterKnife.bind(this);
        TutorApi client = TutorClient.getClient();
        Call<List<TutorResponse>> call = client.getTutors();
        call.enqueue(new Callback<List<TutorResponse>>() {
            @Override
            public void onResponse(Call<List<TutorResponse>> call, Response<List<TutorResponse>> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    tutors = response.body();
                    mAdapter = new TutorListAdapter(TutorActivity.this, tutors);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(TutorActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showTutors();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<List<TutorResponse>> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showTutors() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}