package com.example.agata.loginapp;

import android.content.Context;

/**
 * Created by aciolekwaw on 2015-09-16.
 */
public class Country {

    public String name;
    public String description;
    public String imageName;


    public int getImageResourceId(Context context)
    {
        try {
            return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}