package com.example.cl1434.lee_assignment4;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by COREY on 4/5/2017.
 */

public class Faculty implements Serializable {

    public static String FACULTY_ROOT_KEY = "faculty";
    public static String FACULTY_CATEGORY_KEY = "category";
    public static String FACULTY_USERNAME_KEY = "userName";
    public static String FACULTY_MIDDLENAME_KEY = "middleName";
    public static String FACULTY_DEGREE_KEY = "degree";
    public static String FACULTY_FIRSTNAME_KEY = "firstName";
    public static String FACULTY_LASTNAME_KEY = "lastName";
    public static String FACULTY_TITLE_KEY = "title";
    public static String FACULTY_BIO_KEY = "bio";

    public static String FACULTY_INTENT_KEY = "faculty";

    String category;
    String userName;
    String middleName;
    String degree;
    String firstName;
    String lastName;
    String title;
    String bio;

    public Faculty(String category, String userName, String middleName, String degree, String firstName, String lastName, String title, String bio) {
        this.category = category;
        this.userName = userName;
        this.middleName = middleName;
        this.degree = degree;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
    }

    public Faculty(JSONObject jsonObject) {
        try {
            category = jsonObject.getString(FACULTY_CATEGORY_KEY);
            userName = jsonObject.getString(FACULTY_USERNAME_KEY);
            middleName = jsonObject.getString(FACULTY_MIDDLENAME_KEY);
            degree = jsonObject.getString(FACULTY_DEGREE_KEY);
            firstName = jsonObject.getString(FACULTY_FIRSTNAME_KEY);
            lastName = jsonObject.getString(FACULTY_LASTNAME_KEY);
            title = jsonObject.getString(FACULTY_TITLE_KEY);
            bio = jsonObject.getString(FACULTY_BIO_KEY);
        } catch(JSONException ex) {
            ex.printStackTrace();
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "category='" + category + '\'' +
                ", userName='" + userName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", degree='" + degree + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
