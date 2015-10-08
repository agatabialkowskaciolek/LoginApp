package com.example.agata.loginapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Fragment fragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, fragment).commit();
    }

    private void addDrawerItems() {
        String[] osArray = {"Strona główna", "Android", "iOS", "Windows", "OS X", "Linux"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragment = null;
                FragmentManager fragmentManager;


                switch (position) {

          /*          case 0:
                        fragment = new MainFragment();
                        break;

                    case 1:
                        fragment = new OneFragment();
                        break;*/
                    case 0:
                    case 1:
                        fragment = new OneFragment();
                        break;

                    case 2:
                        fragment = new RecyclerViewScrollListFragment();
                        break;

                  case 3:
                        fragment = new ThreeFragment();
                        break;


                    case 4:
                        fragment = new GridRecyclerViewFragment();
                        break;


                        //Toast.makeText(MainActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
                }

                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main, fragment).commit();
                mDrawerList.setItemChecked(position, true);
                mDrawerList.setSelection(position);
                //getActionBar().setTitle(mNavigationDrawerItemTitles[position]);
                mDrawerLayout.closeDrawer(mDrawerList);
                if (fragment != null) {


                } else {
                    Log.e("MainActivity", "Error in creating fragment");
                }


            }
        });
    }
//,,,
    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

    /*private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private int selectedPosition;
    public static final String SETTING_INFOS = "SETTING_Infos";
    public static final String NAME = "NAME";
    String userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  StringTokenizer tokens = new StringTokenizer(loginEditText.getText().toString(), "@");
        //  String first = tokens.nextToken();// this will contain "Fruit"
        //   String second = tokens.nextToken();// this will contain " they taste good"
       *//* SharedPreferences s = getSharedPreferences(SETTING_INFOS, 0);
        String userLogin = s.getString(NAME, "");
        EditText userLoginEditText = (EditText) findViewById(R.id.loginEditText);
userLogin=userLoginEditText.getText().toString();
       // TextView helloUser = (TextView) findViewById(R.id.helloUserTextView);
        SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);

        settings.edit()
                .putString(NAME,userLogin )
                .apply();
*//*
        //  helloUser.setText(""+first);
        //Bundle bundle = getIntent().getExtras();
        //String message = bundle.getString("key");
        //helloUser.setText(message);


        mTitle = "test";

        mPlanetTitles = new String[]{"one", "two", "three"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  *//* host Activity *//*
                mDrawerLayout,         *//* DrawerLayout object *//*
                R.string.drawer_open,  *//* "open drawer" description *//*
                R.string.drawer_close  *//* "close drawer" description *//*
        );

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);


    }



        *//* Passing selected item information to fragment *//*
       *//* Bundle data = new Bundle();
        data.putString("title", items[selectedPosition]);
        data.putString("url", getUrl());
        rFragment.setArguments(data);
*//*


    *//* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.main, menu);
         return true;
     }
 *//*
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    *//**
     * Swaps fragments in the main content view
 *//*
    private void selectItem(int position) {
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(mPlanetTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

  *//*  @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }*//*

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //selectItem(position);
        }
    }
*/







