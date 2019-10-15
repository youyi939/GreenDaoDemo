package com.example.greendaodemo003;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private Button delete;
    private Button updata;
    private Button find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        updata = findViewById(R.id.updata);
        find = findViewById(R.id.find);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "school", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        final DaoSession session = daoMaster.newSession();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                School school = new School((long)1,"fly");
                session.insert(school);
                Log.d("chen","插入成功");

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                School school = new School((long)1,"fly");
                session.delete(school);
            }
        });


        updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                School school = new School((long)1,"ffffffffly");
                session.update(school);
            }
        });


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<School> school = session.loadAll(School.class);
                String schoolName = "";
                for (int i = 0; i < school.size(); i++) {
                    schoolName += school.get(i).getName() + ",";
                    Log.d("chen",schoolName);
                }
            }
        });

    }
}
