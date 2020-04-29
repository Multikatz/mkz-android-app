package com.multikatz.mkzandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.multikatz.mkzandroidapp.Adapters.StudentAdapter;
import com.multikatz.mkzandroidapp.HttpRequest.IServiceData;
import com.multikatz.mkzandroidapp.HttpRequest.RetrofitClient;
import com.multikatz.mkzandroidapp.Models.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeRefreshLayout;
    IServiceData service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Obteniendo resultados...");
        progressDialog.show();

         service = RetrofitClient.getRetrofitInstance().create(IServiceData.class);

        GetStudentData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetStudentData();
            }
        });
    }

    private  void GetStudentData(){
        Call<List<Student>> call = service.getAllPhotos();

        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                swipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();
                SetStudentData(response.body());
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Ocurrió un error al momento de obtener la información", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SetStudentData(List<Student> studentList) {
        recyclerView = findViewById(R.id.recyvStudent);
        studentAdapter = new StudentAdapter(this,studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }
}
