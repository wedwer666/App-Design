package com.maria.medapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Maria on 17.12.2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    String[] names = {"Maria", "Kleo", "Sanda", "Cristina"};
    String[] descritipion = {"Eye doctor", "Eye doctor", "Eye doctor","Eye doctor"};
    int[] image = {R.drawable.person, R.drawable.person1, R.drawable.person, R.drawable.yes };

    public CustomAdapter(Context ctx)
    {
        this.c = ctx;
    }

    public CustomAdapter(ItemFourFragment itemFourFragment) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int pos) {
        return names[pos];
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list, null);
        }
        //getview
        TextView nametxt = (TextView) convertView.findViewById(R.id.personame);
        TextView typetxt = (TextView) convertView.findViewById(R.id.type);
        ImageView img  = (ImageView) convertView.findViewById(R.id.imgid);
        // set data

        nametxt.setText(names[pos]);
        typetxt.setText(descritipion[pos]);
        img.setImageResource(image[pos]);
        return convertView;
    }
}
