package vn.edu.assigment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class InforCourseActivity extends AppCompatActivity {
private RecyclerView rvInforCourse;
private List<Couser> couserList;
public CourseAdapter courseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_course);
        rvInforCourse=findViewById(R.id.rvInforCourse);

        couserList=new ArrayList<>();

        AppDataBase appDataBase= Room.databaseBuilder(InforCourseActivity.this,AppDataBase.class,"course.db").allowMainThreadQueries().build();

           for (int i=1;i<20;i++){
               Couser couser=new Couser();
               couser.id=i;
               couser.name="Lập trình Android "+i;
               couser.price= 0.0;
               couserList.add(couser);
           }
        rvInforCourse.setHasFixedSize(true);
           courseAdapter=new CourseAdapter(InforCourseActivity.this,couserList,appDataBase);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(InforCourseActivity.this,RecyclerView.VERTICAL,false);
        rvInforCourse.setLayoutManager(linearLayoutManager);
        rvInforCourse.setAdapter(courseAdapter);
    }
}
