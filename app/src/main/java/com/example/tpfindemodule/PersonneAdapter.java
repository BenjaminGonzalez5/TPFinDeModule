package com.example.tpfindemodule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpfindemodule.models.Etudiant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonneAdapter extends ArrayAdapter<Etudiant> {

    public PersonneAdapter(@NonNull Context context, int resource, @NonNull List<Etudiant> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.activity_personne, null);

        TextView textViewName=convertView.findViewById(R.id.textViewPersonneNom);
        TextView textViewEmail=convertView.findViewById(R.id.textViewPersonneEmail);
        ImageView imageView=convertView.findViewById(R.id.imageViewPersonne);

        Etudiant etudiant=getItem(position);

        textViewName.setText(etudiant.getFirstName());
        textViewEmail.setText(etudiant.getMail());
        Picasso.get().load(etudiant.getPictureUrl()).into(imageView);
        return convertView;
    }
}
