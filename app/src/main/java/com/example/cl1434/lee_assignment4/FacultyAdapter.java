package com.example.cl1434.lee_assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by COREY on 4/5/2017.
 */

public class FacultyAdapter extends ArrayAdapter<Faculty> {

    public FacultyAdapter(Context context, ArrayList<Faculty> faculty) {
        super(context, 0, faculty);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Faculty f = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_faculty_list, parent, false);
        }

        TextView facultyNameTextView = (TextView) convertView.findViewById(R.id.facultyNameTextView);
        TextView facultyTitleTextView = (TextView) convertView.findViewById(R.id.facultyTitleTextView);
        ImageView facultyImageView = (ImageView) convertView.findViewById(R.id.facultyImageView);

        facultyNameTextView.setText(f.getFirstName() + " " + f.getLastName() + ", " + f.getDegree());
        facultyTitleTextView.setText(f.getTitle());

        Context context = facultyImageView.getContext();
        int id = context.getResources().getIdentifier(f.getUserName(), "drawable", context.getPackageName());
        facultyImageView.setImageResource(id);

        return convertView;

    }

}
