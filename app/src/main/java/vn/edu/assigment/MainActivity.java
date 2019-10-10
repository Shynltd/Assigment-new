package vn.edu.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Maps(View view) {
    }

    public void News(View view) {
    }

    public void Social(View view) {
    }

    public void Course(View view) {
        startActivity(new Intent(MainActivity.this,CourseActivity.class));
    }
}
