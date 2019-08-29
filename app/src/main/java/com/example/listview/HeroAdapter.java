package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Hero> heroes;

    public HeroAdapter(Context content) {
        this.context = content;
        heroes= new ArrayList<>();
    }

    // to set array list heroes in main
    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // set item for list vview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.itemhero, parent , false);
        }
        ViewHolder viewHolder= new ViewHolder(convertView);
        Hero hero= (Hero)getItem(position);
        viewHolder.bind(hero);
        return convertView;
    }
    // set view holder for list view
    private class ViewHolder{
        private TextView txName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder(View view){
            txName= view.findViewById(R.id.txt_name);
            txtDescription= view.findViewById(R.id.txt_description);
            imgPhoto= view.findViewById(R.id.img_photo);
        }
        void bind(Hero hero){
            txName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
