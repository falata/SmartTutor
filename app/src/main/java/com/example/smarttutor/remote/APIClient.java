package com.example.smarttutor.remote;

import com.example.smarttutor.model.TutorInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static final String BASE_URL = "https://tutors-api.herokuapp.com/tutors";
    private APIService mAPIService;
    private static APIClient INSTANCE;

    public APIClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        mAPIService = retrofit.create(APIService.class);
    }

    //Singleton
    public static APIClient getINSTANCE(){
        if (INSTANCE == null){

        INSTANCE = new APIClient();
        }
        return INSTANCE;
    }
    public Call <List<TutorInfo>> getTutorInfo(){
        return mAPIService.getTutorInfo();
    }
}
