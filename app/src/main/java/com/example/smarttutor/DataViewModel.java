package com.example.smarttutor;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.smarttutor.model.TutorInfo;
import com.example.smarttutor.remote.APIClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
    public MutableLiveData<List<TutorInfo>> tutorInfoMutableData = new MutableLiveData<>();
    public void getTutorInfo(){
        APIClient.getINSTANCE().getTutorInfo().enqueue(new Callback<List<TutorInfo>>() {
            @Override
            public void onResponse(Call<List<TutorInfo>> call, Response<List<TutorInfo>> response) {
                if (response.isSuccessful()){
                      tutorInfoMutableData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<TutorInfo>> call, Throwable t) {
            }
        });

    }
}
