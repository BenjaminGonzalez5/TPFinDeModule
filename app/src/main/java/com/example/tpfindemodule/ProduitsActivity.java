package com.example.tpfindemodule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tpfindemodule.models.Categorie;
import com.example.tpfindemodule.models.Produit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class ProductActivity extends TPActivity {
    private Categorie categroie;
    private ProduitsAdapter produitsAdapter;

    private ArrayList<Produit> produits = new ArrayList<>();

    public static void display(TPActivity activity, Categorie category) {
        Intent intent = new Intent(activity, ProductActivity.class);
        intent.putExtra("category", (Parcelable) category);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);
        showBackBtn();
        categroie = (Categorie) getIntent().getExtras().get("category");

        ListView listView = findViewById(R.id.listViewCategories);
        produitsAdapter = new ProduitsAdapter(this, R.layout.activity_produit, produits);
        listView.setAdapter(produitsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProduitDetailsActivity.display(ProductActivity.this, produits.get(position));
            }
        });

        new HttpAsyTask(categroie.getUrl(), new HttpAsyTask.HttpAsyTaskListener() {
            @Override
            public void webServiceDone(String result) {
                initData(result);
            }

            @Override
            public void webServiceError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();

        setTitle(categroie.getTitre());
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++) {
                Produit produit = new Produit(jsonArray.getJSONObject(i));
                produits.add(produit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        produitsAdapter.notifyDataSetChanged();
    }
}
