package com.example.cl1434.lee_assignment4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FacultyDetailActivity extends AppCompatActivity {

    TextView facultyDetailNameTextView, facultyDetailTitleTextView, facultyDetailBioTextView;
    ImageView facultyDetailImageView;
    Button websiteButton;
    Faculty f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_detail);

        Intent i = getIntent();
        f = (Faculty) i.getSerializableExtra(Faculty.FACULTY_INTENT_KEY);
        setTitle(f.getLastName());

        facultyDetailNameTextView = (TextView) findViewById(R.id.facultyDetailNameTextView);
        facultyDetailTitleTextView = (TextView) findViewById(R.id.facultyDetailTitleTextView);
        facultyDetailBioTextView = (TextView) findViewById(R.id.facultyDetailBioTextView);
        facultyDetailImageView = (ImageView) findViewById(R.id.facultyDetailImageView);
        websiteButton = (Button) findViewById(R.id.websiteButton);

        facultyDetailNameTextView.setText(f.getFirstName() + " " + f.getLastName() + ", " + f.getDegree());
        facultyDetailTitleTextView.setText(f.getTitle());
        facultyDetailBioTextView.setText(f.getBio());

        Context context = facultyDetailImageView.getContext();
        int id = context.getResources().getIdentifier(f.userName, "drawable", context.getPackageName());
        facultyDetailImageView.setImageResource(id);

    }

    public void gotoWebsite(View view) {
        String url = "http://cec.nova.edu/~" + f.getUserName();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
