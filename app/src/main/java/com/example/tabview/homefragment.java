package com.example.tabview;

import android.content.Intent;
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

public class homefragment extends Fragment {
    String api="7a9f22539ecd4168a794a3bb108a9516";
    ArrayList<ModalClass> modalClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewhome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.home,null) ;
        recyclerViewhome=v.findViewById(R.id.rvhome);
        modalClassArrayList=new ArrayList<>();
        recyclerViewhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modalClassArrayList);
        recyclerViewhome.setAdapter(adapter);

        findNews();
        return v;
    }

    private void findNews() {
        apiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainModalClass>() {
            @Override
            public void onResponse(Call<MainModalClass> call, Response<MainModalClass> response) {
                if(response.isSuccessful()){
                    modalClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainModalClass> call, Throwable t) {

            }
        });
    }
}
