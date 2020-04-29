package com.example.tpfindemodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpfindemodule.models.Produit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProduitsAdapter extends ArrayAdapter<Produit> {


    public ProduitsAdapter(@NonNull Context context, int resource, ArrayList<Produit> produits) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.activity_produit, null);

        TextView textViewTitle = convertView.findViewById(R.id.textViewProductName);
        TextView textViewDescription = convertView.findViewById(R.id.textViewProductDescription);
        ImageView imageView = convertView.findViewById(R.id.imageViewProduct);

        Produit produit = getItem(position);

        assert produit != null;
        textViewTitle.setText(produit.getName());
        textViewDescription.setText(produit.getDescription());
        Picasso.get().load(produit.getUrl()).into(imageView);

        return convertView;
    }
}
