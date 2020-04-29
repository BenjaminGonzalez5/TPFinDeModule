package com.example.tpfindemodule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpfindemodule.models.Etudiant;
import com.squareup.picasso.Picasso;

public class PersonnesDetailsActivity extends TPActivity {

    private Etudiant etudiant;

    public static void display(TPActivity activity, Etudiant Etudiant){
        Intent intent=new Intent(activity,PersonnesDetailsActivity.class);
        intent.putExtra("Etudiant", (Parcelable) Etudiant);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personne);
        showBackBtn();
        etudiant = (Etudiant) getIntent().getExtras().get("Etudiant");

        ImageView imageViewDetails= findViewById(R.id.imageViewPersonne);
        TextView textLastName = findViewById(R.id.textViewPersonneNom);
        TextView textFirstName = findViewById(R.id.textViewPersonnePrenom);
        TextView textEmail = findViewById(R.id.textViewPersonneEmail);
        TextView textWebsite = findViewById(R.id.textViewPersonneWebsite);


        Picasso.get().load(etudiant.getPictureUrl()).into(imageViewDetails);
        textLastName.setText(etudiant.getLastName());
        textFirstName.setText(etudiant.getFirstName());
        textEmail.setText(etudiant.getMail());
        textWebsite.setText(etudiant.getWebsite());

        setTitle(etudiant.getFirstName());

    }
}
