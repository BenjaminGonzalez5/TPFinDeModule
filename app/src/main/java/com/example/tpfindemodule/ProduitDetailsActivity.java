package com.example.tpfindemodule;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpfindemodule.models.Produit;
import com.squareup.picasso.Picasso;

public class ProduitDetailsActivity extends TPActivity {
    private Produit produit;

    public static void display(TPActivity activity, Produit produit) {
        Intent intent = new Intent(activity, ProduitDetailsActivity.class);
        intent.putExtra("Produit", produit);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_produits);
        showBackBtn();
        produit = (Produit) getIntent().getExtras().get("Product");

        TextView textProductDescription = findViewById(R.id.textViewDescriptionDetails);
        ImageView imageViewDetails = findViewById(R.id.imageViewProduct);

        textProductDescription.setText(produit.getDescription());
        Picasso.get().load(produit.getUrl()).into(imageViewDetails);

        setTitle(produit.getName());

    }
}
