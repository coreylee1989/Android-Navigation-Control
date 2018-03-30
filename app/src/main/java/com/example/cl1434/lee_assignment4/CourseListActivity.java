package com.example.cl1434.lee_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {

    ListView courseListView;
    ArrayList<Course> course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Courses");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        courseListView = (ListView) findViewById(R.id.courseListView);

        //Process JSON
        processCourseJSON();
        Log.d("DEBUG", course.toString());

        //Create Adapter
        CourseAdapter adapter = new CourseAdapter(this, course);
        courseListView.setAdapter(adapter);

        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", Integer.toString(position));
                Course c = (Course) parent.getItemAtPosition(position);

                Intent i = new Intent(CourseListActivity.this, CourseDetailActivity.class);
                i.putExtra(Course.COURSE_INTENT_KEY, c);
                startActivity(i);
            }
        });

    }

    void processCourseJSON() {
        String s = loadJSON();
        Log.d("DEBUG", s);

        course = new ArrayList<Course>();

        try {
            JSONObject obj = new JSONObject(s);
            JSONArray jsonArray = obj.getJSONArray(Course.COURSE_ROOT_KEY);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject courseObject = jsonArray.getJSONObject(i);
                Course c = new Course(courseObject);
                course.add(c);
            }

        } catch(JSONException ex) {
            ex.printStackTrace();
        }

    }

    String loadJSON() {

        String json = null;

        try {
            InputStream is = getResources().openRawResource(R.raw.courses_data);
            int size = is.available();
            byte [] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}
