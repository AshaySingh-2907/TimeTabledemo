package com.example.anshi.timetabledemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.chrisbanes.photoview.PhotoView;

public class SubjectDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        PhotoView photoView = findViewById(R.id.photo_view);

        int sub_pos=SubjectActivity.sharedPreferences.getInt(SubjectActivity.SEL_SUBJECT,0);

        int[] subImages=new int[]
                {
                     R.drawable.maths,R.drawable.ss, R.drawable.ica, R.drawable.aca, R.drawable.ecad,R.drawable.nt,R.drawable.pcs
                };


        photoView.setImageResource(subImages[sub_pos]);


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
