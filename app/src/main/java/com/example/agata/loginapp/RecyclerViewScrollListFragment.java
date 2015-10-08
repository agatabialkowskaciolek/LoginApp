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

public class RecyclerViewScrollListFragment extends Fragment implements ContactAdapter.OnCardClick {


    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    protected String[] mDataset;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ContactAdapter contactAdapter;
    private List<ContactInfo> result = new ArrayList<ContactInfo>();
    private RecyclerView.LayoutManager mLayoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayoutManager linearLayoutManager;


    public RecyclerViewScrollListFragment() {

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
    public static RecyclerViewScrollListFragment newInstance(String param1, String param2) {
        RecyclerViewScrollListFragment fragment = new RecyclerViewScrollListFragment();
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


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);


        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        createList(6);
        contactAdapter = new ContactAdapter(result, R.layout.card_layout, getActivity(), this);
        recyclerView.setAdapter(contactAdapter);

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
                contactAdapter.notifyDataSetChanged();
                contactAdapter.getItemCount();
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(), "rrrrrrrrrrrrr", Toast.LENGTH_SHORT).show();
                linearLayoutManager.setReverseLayout(true);
                linearLayoutManager.scrollToPositionWithOffset(0, 50);

            }


        });

        return view;
    }

    private void refreshContent() {

        Toast.makeText(getActivity(), "refresh", Toast.LENGTH_SHORT).show();
    }

    private List<ContactInfo> createList(int size) {


        for (int i = 1; i <= size; i++) {
            Intent in = new Intent(getActivity(), CardActivity.class);

            ContactInfo ci = new ContactInfo();
            ci.name = ContactInfo.NAME_PREFIX + i;
            ci.surname = ContactInfo.SURNAME_PREFIX + i;
            ci.email = ContactInfo.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

            in.putExtra("name", ContactInfo.NAME_PREFIX + i);
         /*   String test = result.toString();
            Toast.makeText(getActivity(),"test!!!"+test, Toast.LENGTH_SHORT).show();
*/
        }

        return result;
    }

    @Override
    public void onTap(int position) {

        Intent intent = new Intent(getActivity(), CardActivity.class);
        Bundle args = new Bundle();
        intent.putExtra("key", Integer.toString(position));
        startActivity(intent);
        Toast.makeText(getActivity(), "mg" + position, Toast.LENGTH_SHORT).show();

    }
}

