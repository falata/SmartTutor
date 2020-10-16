package com.example.smarttutor.remote;

import com.example.smarttutor.model.TutorInfo;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("api/tutorInfo")
    Call<List<TutorInfo>> getTutorInfo();
}
