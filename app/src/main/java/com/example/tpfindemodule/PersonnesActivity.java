package com.example.tpfindemodule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.tpfindemodule.models.Etudiant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonnesActivity extends TPActivity {

    private String data =" {\"items\": [{\"picture_url\": \"https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/p960x960/60746468_1716827775130131_2851683904576815104_o.jpg?_nc_cat=108&_nc_sid=85a577&_nc_ohc=DaAMsnHokJYAX9gsgOy&_nc_ht=scontent-cdg2-1.xx&_nc_tp=6&oh=0556bffb1bc59cb7dc58d475cd900f7a&oe=5ECD855C\",\"last_name\": \"Gonzalez\",\"first_name\":\"Benjamin\",\"mail\": \"benjamin.gonzalez@epsi.fr\"},{\"picture_url\": \"https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/21231290_1469616126419166_5088227161654493947_n.jpg?_nc_cat=111&_nc_sid=85a577&_nc_ohc=sIrEy9zwnMQAX_ZUXDX&_nc_ht=scontent-cdg2-1.xx&oh=3cd42a489a7aacd89e5402118869e157&oe=5ED0F68B\",\"last_name\": \"Rodrigues\",\"first_name\": \"Matthieu\",\"mail\": \"matthieu.rodrigues@epsi.fr.\"}]}";
    public ArrayList<Etudiant> etudiants;

    public static void display(TPActivity activity){
        Intent intent=new Intent(activity, PersonnesActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnes);
        showBackBtn();
        initData();
        ListView listView=findViewById(R.id.listViewCategories);
        PersonneAdapter adapter=new PersonneAdapter(this,R.layout.activity_personne,etudiants);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PersonnesDetailsActivity.display(PersonnesActivity.this,etudiants.get(position));
            }
        });
    }

    private void initData() {
        etudiants=new ArrayList<>();
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Etudiant student=new Etudiant(jsonArray.getJSONObject(i));
                etudiants.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(etudiants.size()));
    }
}
