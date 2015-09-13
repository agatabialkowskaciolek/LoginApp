package com.example.agata.loginapp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Agata on 2015-09-13.
 */
public class FragmentThree extends Fragment {

    public static Fragment newInstance(Context context) {
        FragmentThree f = new FragmentThree();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_three, null);
        return root;
    }
}
