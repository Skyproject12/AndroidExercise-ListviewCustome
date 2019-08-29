package com.example.listview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private TypedArray dataPhoto;
    private String[] dataDescription;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // cal array list data name
        adapter= new HeroAdapter(this);
        // check default data list view
        //ArrayAdapter<String>adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
        ListView listView= findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        Prepare();
        addItem();
        // make onclick in lisview listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, heroes.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    // menampung semua file dalam array lalu dimasukkan ke dalam array list
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
    private void Prepare(){
        dataName= getResources().getStringArray(R.array.data_name);
        dataDescription= getResources().getStringArray(R.array.data_description);
        dataPhoto= getResources().obtainTypedArray(R.array.data_photo);
    }
}
