package com.example.tabview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class healthfragment extends Fragment {

    String api="7a9f22539ecd4168a794a3bb108a9516";
    ArrayList<ModalClass> articles;
    Adapter adapter;
    String country="in";
    RecyclerView recyclerView;
    private String category="health";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.health,null) ;
        recyclerView=v.findViewById(R.id.rvhealth);
        articles=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),articles);
        recyclerView.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {
        apiUtilities.getApiInterface().getCategoryNews(country,100,category,api).enqueue(new Callback<MainModalClass>() {
            @Override
            public void onResponse(Call<MainModalClass> call, Response<MainModalClass> response) {
                if(response.isSuccessful()){
                    articles.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainModalClass> call, Throwable t) {

            }
        });
    }
}
