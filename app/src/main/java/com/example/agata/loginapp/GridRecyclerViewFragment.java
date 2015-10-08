package com.example.agata.loginapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aciolekwaw on 2015-10-01.
 */
public class GridRecyclerViewFragment extends Fragment {

    RecyclerView mRecyclerView;


    public GridRecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.layout_fragment_four,container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.masonry_grid);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        MasonryAdapter adapter = new MasonryAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);

        return view;
    }
}
