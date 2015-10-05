package com.example.agata.loginapp;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {


    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.layout_fragment_three,container,false);

        FloatingActionButton myFab = (FloatingActionButton)  view.findViewById(R.id.fab_fragment3);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(
                R.id.recycler_view);
        recyclerView.addItemDecoration(new MarginDecoration(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new NumberedAdapter(30));

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (4 - position % 4);
            }
        });
        recyclerView.setLayoutManager(manager);

        return view;
    }


}
