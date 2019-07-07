package com.example.anshi.timetabledemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anshi.timetabledemo.Utils.LetterImageView;

public class SubjectActivity extends AppCompatActivity {


    public static String SEL_SUBJECT;
    private Toolbar toolbar;
    private ListView listView;
    private String subjects[];
    public static SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setupUIViews();
        initToolbar();
        setupListView();
    }


    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubject);
        listView = (ListView)findViewById(R.id.lvSubject);
        sharedPreferences = getSharedPreferences("mySubject", MODE_PRIVATE);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subject");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    private  void setupListView()
    {

        subjects=getResources().getStringArray(R.array.Subjects);
    SubjectAdapter subjectAdapter=new SubjectAdapter(this,R.layout.subject_single_item,subjects);

    listView.setAdapter(subjectAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position){
                case 0:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 0).apply();
                break;
                }

                case 1:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 1).apply();
                    break;
                }
                case 2:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 2).apply();
                    break;
                }
                case 3:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 3).apply();
                    break;
                }
                case 4:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 4).apply();
                    break;
                }
                case 5:{
                    startActivity(new Intent(SubjectActivity.this, SubjectDetails.class));
                    sharedPreferences.edit().putInt(SEL_SUBJECT, 5).apply();
                    break;
                }


            }

        }
    });

    }
    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects;

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subjects = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterSubject);
                holder.tvSubject = (TextView)convertView.findViewById(R.id.tvSubject);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.tvSubject.setText(subjects[position]);
            holder.ivLogo.setLetter(subjects[position].charAt(0));


            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvSubject;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

}
