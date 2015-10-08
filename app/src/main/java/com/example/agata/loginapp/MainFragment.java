package com.example.agata.loginapp;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.StringTokenizer;


public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MainFragment() {

    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView helloUser = (TextView) view.findViewById(R.id.helloUser);

        SharedPreferences settings = getActivity().getSharedPreferences(LoginActivity.SETTING_INFOS, 0);
        String userLogin = settings.getString(LoginActivity.NAME, "");
        StringTokenizer tokens = new StringTokenizer(userLogin, "@");
        String first = tokens.nextToken();// this will contain "Fruit"
        String second = tokens.nextToken();// this will contain " they taste good"
        helloUser.setText("Hello " + first);
        helloUser.setVisibility(View.VISIBLE);
        return view;


    }


}
