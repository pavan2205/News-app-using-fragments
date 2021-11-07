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

public class sciencefragment extends Fragment {
    String api="7a9f22539ecd4168a794a3bb108a9516";
    ArrayList<ModalClass> modalClassArrayList;
    Adapter adapter;
    String country="in";
    RecyclerView recyclerView;
    private String category="science";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.science,null);
        recyclerView=v.findViewById(R.id.rvscience);
        modalClassArrayList =new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modalClassArrayList);
        recyclerView.setAdapter(adapter);
        
        findNews();
        return  v;
    }

    private void findNews() {
        apiUtilities.getApiInterface().getCategoryNews(country,100,category,api).enqueue(new Callback<MainModalClass>() {
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
