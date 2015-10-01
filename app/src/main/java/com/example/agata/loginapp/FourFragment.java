package com.example.agata.loginapp;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by aciolekwaw on 2015-10-01.
 */
public class FourFragment extends Fragment {

    public FourFragment() {
        // Required empty public constructor
    }


    RecyclerView mRecyclerView;

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
