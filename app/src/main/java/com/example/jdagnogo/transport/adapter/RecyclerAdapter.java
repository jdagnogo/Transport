package com.example.jdagnogo.transport.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.jdagnogo.transport.R;
import com.example.jdagnogo.transport.TransportApplication;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<RelativeLayout> placeholderList;
    RecyclerView recyclerView;
    private Animator spruceAnimator;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout placeholderView;


        ViewHolder(View itemView) {
            super(itemView);
            placeholderView = (RelativeLayout) itemView.findViewById(R.id.placeholder_view);
            placeholderView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //if (spruceAnimator != null) {
           //    spruceAnimator.start();
            //}
        }
    }

    public RecyclerAdapter(List<RelativeLayout> placeholderList,RecyclerView recyclerView) {
        this.placeholderList = placeholderList;
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(initLayoutManager());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout view = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_placeholder, parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.placeholderView = placeholderList.get(position);
    }

    @Override
    public int getItemCount() {
        return placeholderList.size();
    }

    private LinearLayoutManager initLayoutManager(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TransportApplication.getAppContext()) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                super.onLayoutChildren(recycler, state);
                // Animate in the visible children
                spruceAnimator = new Spruce.SpruceBuilder(recyclerView)
                        .sortWith(new DefaultSort(100))
                        .animateWith(DefaultAnimations.shrinkAnimator(recyclerView, 800),
                                ObjectAnimator.ofFloat(recyclerView, "translationX", -recyclerView.getWidth(), 0f).setDuration(800))
                        .start();

            }
        };
        return linearLayoutManager;
    }

}