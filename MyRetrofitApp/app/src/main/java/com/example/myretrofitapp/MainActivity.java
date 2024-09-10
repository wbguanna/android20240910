package com.example.myretrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myretrofitapp.http.ApiClient;
import com.example.myretrofitapp.http.ApiService;
import com.example.myretrofitapp.http.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // 화면부
    private RecyclerView recyclerView;
    // 데이터부
    private MyAdapter myAdapter;
    // 아래의 call.enqueue 동기식이므로 간단하게
    private List<Post> posts;

    final int[] failureCnt = new int[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Post>> call = apiService.getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    posts = response.body();
                    for (Post post : posts) {
                        Log.d("RetrofitExample", "Title: " + post.getTitle());
                    }
                    // activity_main.xml에 정의한 RecyclerView
                    recyclerView = findViewById(R.id.recyclerView);

                    // MyAdapter 생성자에 itemList를 전달하여 어댑터가 사용할 데이터를 설정
                    myAdapter = new MyAdapter(posts);
                    // RecyclerView의 레이아웃을 선형으로 설정
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    // setLayoutManager 메서드를 사용하여 RecyclerView에 레이아웃 매니저를 설정.
                    recyclerView.setLayoutManager(layoutManager);
                    // setAdapter 메서드를 사용하여 RecyclerView에 어댑터를 설정.
                    // 이로써 RecyclerView는 itemList 데이터를 사용하여 아이템을 표시하게 됨.
                    recyclerView.setAdapter(myAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("RetrofitExample", "Error: " + t.getMessage());

                if (failureCnt[0] != 3) {
                    call.enqueue(this);
                    failureCnt[0] += 1;
                } else {
                    failureCnt[0] = 0;
                }
            }
        });
    }
}