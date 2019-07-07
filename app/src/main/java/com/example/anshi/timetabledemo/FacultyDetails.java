package com.example.anshi.timetabledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {


    private CircleImageView facultyImage;
    private androidx.appcompat.widget.Toolbar toolbar;
    private TextView facultyName,phoneNumber,email,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);
    setupUIViews();
    initToolbar();
    setUpdetails();

    }

    private  void  setupUIViews()
    {
        toolbar=findViewById(R.id.ToolbarFacultyDetails);
        facultyImage=findViewById(R.id.ivFaculty);
        facultyName=findViewById(R.id.tvFacultySelName);
        email=findViewById(R.id.tvEmail);
        phoneNumber=findViewById(R.id.tvPhoneNumber);
        place=findViewById(R.id.tvPlace);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpdetails()
    {
        int faculty_pos=FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_FACULTY,0);
        String[] facultyNames=getResources().getStringArray(R.array.faculty_name);

        int[] facultyImages=new int[]
                {
                        R.drawable.book,R.drawable.calendar,R.drawable.resources,R.drawable.subs,R.drawable.settings,R.drawable.timetable
                };
        int[] facultyArray=new  int[]
                {
                        R.array.faculty1,
                        R.array.faculty2,
                        R.array.faculty3,
                        R.array.faculty4,
                        R.array.faculty5,
                        R.array.faculty6,
                };

    String[] facultyDetails=getResources().getStringArray(facultyArray[faculty_pos]);

    phoneNumber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        place.setText(facultyDetails[2]);

        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultyNames[faculty_pos]);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

