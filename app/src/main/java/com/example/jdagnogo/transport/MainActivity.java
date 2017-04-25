package com.example.jdagnogo.transport;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.example.jdagnogo.transport.adapter.RecyclerAdapter;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar toolBar = (Toolbar) findViewById(R.id.recycler_tool_bar);
        //setSupportActionBar(toolBar);

        initRecycler();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    private void initRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        RelativeLayout placeholder = (RelativeLayout) findViewById(R.id.placeholder_view);
        List<RelativeLayout> placeHolderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            placeHolderList.add(placeholder);
        }

        recyclerView.setAdapter(new RecyclerAdapter(placeHolderList,recyclerView));

    }


}
