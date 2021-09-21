package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Custom1 extends ArrayAdapter {

    Activity activity;
    String[] name;
    String[] description;
    Integer[] image;

    TextView textViewTitle,textViewDescription;
    ImageView imageView;

    public Custom1(@NonNull Context context,String[] name, String[] description,
                   Integer[] textViewResourceId) {
        super(context,R.layout.activity_main,R.id.text_title,name);
        activity = (Activity) context;
        this.name = name;
        this.description = description;
        image = textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(R.layout.single,null);
        textViewTitle = convertView.findViewById(R.id.text_title);
        textViewDescription = convertView.findViewById(R.id.text_desc);
        imageView = convertView.findViewById(R.id.image1);
        textViewTitle.setText(name[position]);
        textViewDescription.setText(description[position]);
        imageView.setImageResource(image[position]);

        return convertView;
    }
}
