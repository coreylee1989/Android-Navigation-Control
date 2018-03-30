package com.example.cl1434.lee_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {

    TextView courseDetailNameTextView, courseDetailShortDescTextView, courseDetailLongDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent i = getIntent();
        Course c = (Course) i.getSerializableExtra(Course.COURSE_INTENT_KEY);
        setTitle(c.getName());

        courseDetailNameTextView = (TextView) findViewById(R.id.courseDetailNameView);
        courseDetailShortDescTextView = (TextView) findViewById(R.id.courseDetailShortDescTextView);
        courseDetailLongDescTextView = (TextView) findViewById(R.id.courseDetailLongDescTextView);

        courseDetailNameTextView.setText(c.getName());
        courseDetailShortDescTextView.setText(c.getShortDesc());
        courseDetailLongDescTextView.setText(c.getLongDesc());

    }
}
