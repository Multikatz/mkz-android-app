package com.multikatz.mkzandroidapp.HttpRequest;

import com.multikatz.mkzandroidapp.Models.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IServiceData {
    @GET("Student/GetAll")
    Call<List<Student>> getAllPhotos();
}
