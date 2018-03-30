package com.example.cl1434.lee_assignment4;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by COREY on 4/5/2017.
 */

public class Course implements Serializable {

    public static String COURSE_ROOT_KEY = "courses";
    public static String COURSE_NAME_KEY = "name";
    public static String COURSE_SHORTDESC_KEY = "shortDesc";
    public static String COURSE_LONGDESC_KEY = "longDesc";

    public static String COURSE_INTENT_KEY = "course";


    String name;
    String shortDesc;
    String longDesc;

    public Course(String name, String shortDesc, String longDesc) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public Course(JSONObject jsonObject) {
        try {
            name = jsonObject.getString(COURSE_NAME_KEY);
            shortDesc = jsonObject.getString(COURSE_SHORTDESC_KEY);
            longDesc = jsonObject.getString(COURSE_LONGDESC_KEY);
        } catch(JSONException ex) {
            ex.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
