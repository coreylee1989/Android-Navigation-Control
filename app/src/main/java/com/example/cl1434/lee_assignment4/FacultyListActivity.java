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

public class FacultyListActivity extends AppCompatActivity {

    ListView facultyListView;
    ArrayList<Faculty> faculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Faculty");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_list);

        facultyListView = (ListView) findViewById(R.id.facultyListView);

        //Process JSON
        processFacultyJSON();
        Log.d("DEBUG", faculty.toString());

        //Create Adapter
        FacultyAdapter adapter = new FacultyAdapter(this, faculty);
        facultyListView.setAdapter(adapter);

        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("DEBUG", Integer.toString(position));
                Faculty f = (Faculty) parent.getItemAtPosition(position);

                Intent i = new Intent(FacultyListActivity.this, FacultyDetailActivity.class);
                i.putExtra(Faculty.FACULTY_INTENT_KEY, f);
                startActivity(i);
            }
        });

    }

    void processFacultyJSON() {
        String s = loadJSON();
        Log.d("DEBUG", s);

        faculty = new ArrayList<Faculty>();

        try {
            JSONObject obj = new JSONObject(s);
            JSONArray jsonArray = obj.getJSONArray(Faculty.FACULTY_ROOT_KEY);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject facultyObject = jsonArray.getJSONObject(i);
                Faculty f = new Faculty(facultyObject);
                faculty.add(f);
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }

    }

    String loadJSON() {

        String json = null;

        try {
            InputStream is = getResources().openRawResource(R.raw.faculty_data);
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
