package com.earaujo.poc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PaginationAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rvToDoList);

        adapter = new PaginationAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);

        loadRv();
    }

    private void loadRv() {
        List<Brand> results = new ArrayList<>();
        Brand brand = new Brand();
        brand.setName("nomedabrand");
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        results.add(brand);
        adapter.addAll(results);
    }
}
