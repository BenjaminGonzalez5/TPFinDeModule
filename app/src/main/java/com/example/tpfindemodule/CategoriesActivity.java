package com.example.tpfindemodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.tpfindemodule.models.Categorie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoriesActivity extends TPActivity{
    private CategoriesAdapter categorieAdapter;

    private ArrayList<Categorie> categories = new ArrayList<>();

    public static void display(TPActivity activity) {
        Intent intent = new Intent(activity, CategoriesActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        showBackBtn();
        ListView listView = findViewById(R.id.listViewCategories);
        categorieAdapter = new CategoriesAdapter(this, R.layout.activity_categorie, categories);
        listView.setAdapter(categorieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProduitsActivity.display(CategoriesActivity.this, categories.get(position));
            }
        });

        setTitle("Rayons");

        String url = "https://djemam.com/epsi/categories.json";

        new HttpAsyTask(url, new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                Categorie categorie = new Categorie(jsonArray.getJSONObject(i));
                categories.add(categorie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        categorieAdapter.notifyDataSetChanged();
    }

}


