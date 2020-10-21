package com.example.smarttutor.services;

import com.example.smarttutor.Constants;
import com.example.smarttutor.models.Tutor;
import com.example.smarttutor.models.TutorResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TutorService {
    public static void getTutors(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.Tutor_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Tutor> processResults(Response response) {
        ArrayList<Tutor> tutors = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject tutorJSON = new JSONObject(jsonData);
            JSONArray tutorsJSON = tutorJSON.getJSONArray("tutors");
            if (response.isSuccessful()) {
                for (int i = 0; i < tutorsJSON.length(); i++) {
                    JSONObject tutorsObjectJSON = tutorsJSON.getJSONObject(i);
                    String name = tutorsObjectJSON.getString("name");
                    String phone = tutorsObjectJSON.optString("phone");
                    String subjects = tutorsObjectJSON.getString("subjects");
                    double rating = tutorsObjectJSON.getDouble("rating");
                    String imageUrl = tutorsObjectJSON.getString("imageUrl");
                    String bio =tutorsObjectJSON .getString("bio") ;
                    String experience =tutorsObjectJSON .getString("experience") ;

                    Tutor tutor = new Tutor(experience,subjects,name, phone,
                            rating,imageUrl,bio);
                    tutors.add(tutor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tutors;
    }
}
