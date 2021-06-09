package com.raj_shah.custom_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
    Context context;
    int image[];
    String name[];
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, int[] image, String[] name){
        this.context=context;
        this.image=image;
        this.name=name;

        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.row_listview,null);

        ImageView imageView=convertView.findViewById(R.id.iv1);
        TextView textView=convertView.findViewById(R.id.tv1);

        imageView.setImageResource(image[position]);
        textView.setText(name[position]);

        return convertView;
    }
}
