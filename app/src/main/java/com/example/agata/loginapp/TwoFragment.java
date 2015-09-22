package com.example.agata.loginapp;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment implements ContactAdapter.OnCardClick {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected String[] mDataset;
    private RecyclerView mRecyclerView;
    private CountryAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ContactAdapter ca;
    private List<ContactInfo> result = new ArrayList<ContactInfo>();
    private RecyclerView.LayoutManager mLayoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager llm;


    public TwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TwoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
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
        View view = inflater.inflate(R.layout.recyclerview_layout, container, false);


        final RecyclerView recList = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recList.setHasFixedSize(true);


        llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        createList(6);
        ca = new ContactAdapter(result, R.layout.card_layout, getActivity(), this);
        recList.setAdapter(ca);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {
                // refreshContent();
                ContactInfo ci = new ContactInfo();
                ci.name = ContactInfo.NAME_PREFIX;
                ci.surname = ContactInfo.SURNAME_PREFIX;
                ci.email = ContactInfo.EMAIL_PREFIX + "@test.com";

                result.add(ci);

                ca.notifyDataSetChanged();
                ca.getItemCount();
                swipeRefreshLayout.setRefreshing(false);


                // ca2.onBindViewHolder();

                Toast.makeText(getActivity(), "rrrrrrrrrrrrr", Toast.LENGTH_SHORT).show();

                llm.setReverseLayout(true);
                llm.scrollToPositionWithOffset(0, 50);

            }


        });


        return view;
    }



    /*private void updateList() {
        ContactAdapter mAdapter = new ContactAdapter(createList(1), R.layout.card_layout, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }*/

    private void refreshContent() {

        Toast.makeText(getActivity(), "refresh", Toast.LENGTH_SHORT).show();
    }

    private List<ContactInfo> createList(int size) {


        for (int i=1; i <= size; i++) {
            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.surname = ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }


    @Override
    public void onTap(int position) {

        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("key", position);
        startActivity(intent);
        Toast.makeText(getActivity(), "mg" + position, Toast.LENGTH_SHORT).show();

    }
}

