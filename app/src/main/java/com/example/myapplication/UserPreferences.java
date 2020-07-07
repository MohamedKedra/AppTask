package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    SharedPreferences sharedpreferences;

    public static final String PREF = "pref" ;
    public static final String NAME = "name";
    public static final String CURRENT = "current";
    public static final String MAX = "max";

    public UserPreferences(Context context) {
        sharedpreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
    }

    public void setUserName(String userName){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(NAME, userName);
        editor.apply();
    }

    public String getUserName(){
        return sharedpreferences.getString(NAME,"");
    }


    public void setCurrentNum(String current){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CURRENT, current);
        editor.apply();
    }

    public String getCurrentNum(){
        return sharedpreferences.getString(CURRENT,"");
    }


    public void setMaxNum(String maxNum){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(MAX, maxNum);
        editor.apply();
    }

    public String getMaxNum(){
        return sharedpreferences.getString(MAX,"");
    }
}
