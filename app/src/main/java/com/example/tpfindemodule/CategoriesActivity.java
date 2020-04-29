package com.example.tpfindemodule;

import android.content.Intent;

public class CategoriesActivity {
    public static void display(TPActivity activity){
        Intent intent=new Intent(activity, CategoriesActivity.class);
        activity.startActivity(intent);
    }

}


