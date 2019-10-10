package vn.edu.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CourseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

    }

    public void InfoCourse(View view) {
        startActivity(new Intent(CourseActivity.this, InforCourseActivity.class));
    }

    public void SubCourse(View view) {
        startActivity(new Intent(CourseActivity.this, SubCourseActivity.class));
    }
}
