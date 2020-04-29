package com.example.tpfindemodule;

import android.content.Intent;

public class PersonnesActivity {
    public static void display(TPActivity activity){
        Intent intent=new Intent(activity, PersonnesActivity.class);
        activity.startActivity(intent);
    }

}
