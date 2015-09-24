package com.example.agata.loginapp;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
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
        return view;
    }


}
