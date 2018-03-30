package com.example.cl1434.lee_assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by COREY on 4/5/2017.
 */

public class CourseAdapter extends ArrayAdapter<Course> {

    public CourseAdapter(Context context, ArrayList<Course> course) {
        super(context, 0, course);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course c = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_course_list, parent, false);
        }

        TextView courseNameTextView = (TextView) convertView.findViewById(R.id.courseNameTextView);
        TextView courseShortDescTextView = (TextView) convertView.findViewById(R.id.courseShortDescTextView);

        courseNameTextView.setText(c.getName());
        courseShortDescTextView.setText(c.getShortDesc());

        return convertView;

    }

}
