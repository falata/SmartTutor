package com.example.smarttutor.network;

import com.example.smarttutor.models.Tutor;
import com.example.smarttutor.models.TutorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TutorApi {
    @GET("tutors")
    Call<List<TutorResponse>> getTutors();

}
