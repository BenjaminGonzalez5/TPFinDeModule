package com.example.tpfindemodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpfindemodule.models.Categorie;

import java.util.ArrayList;
import java.util.List;

class CategoriesAdapter extends ArrayAdapter<Categorie> {

    public CategoriesAdapter(@NonNull Context context, int resource, ArrayList<Categorie> categories) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.activity_categorie, null);

        TextView textViewTitle = convertView.findViewById(R.id.textViewCategoryTitle);

        Categorie categorie = getItem(position);

        assert categorie != null;
        textViewTitle.setText(categorie.getTitre());
        return convertView;
    }
}
