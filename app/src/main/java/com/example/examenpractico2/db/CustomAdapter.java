package com.example.examenpractico2.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examenpractico2.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Promedio> lst;

    public CustomAdapter(Context context, List<Promedio> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView titulo;
        ImageView imageViewKilometros;
        ImageView imageViewCostos;
        TextView textViewKilometros;
        TextView textViewCostos;


        Promedio p = lst.get(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_promedio,null);

        }
        titulo = convertView.findViewById(R.id.txvTituloList);
        imageViewKilometros = convertView.findViewById(R.id.imgvKilometros);
        imageViewCostos = convertView.findViewById(R.id.imgvCosto);
        textViewKilometros = convertView.findViewById(R.id.txvKilometros);
        textViewCostos = convertView.findViewById(R.id.txvCosto);


        return convertView;
    }
}
