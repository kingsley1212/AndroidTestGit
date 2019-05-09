package com.bai.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bai.myapplication.sql.DBserver;
import com.bai.myapplication.sql.UserInfoEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBserver db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBserver(this);
        TextView text = (TextView) findViewById(R.id.text);
        TextView text1 = (TextView) findViewById(R.id.text1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    UserInfoEntity userInfoEntity = new UserInfoEntity();
                    userInfoEntity.setId(i + "");
                    userInfoEntity.setName(i + "是金");
                    userInfoEntity.setAge(i + "");
                    userInfoEntity.setSex(i % 2 == 0 ? "男" : "女");
                    db.addUser(userInfoEntity);
                }
            }
        });
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<UserInfoEntity> entities = db.findAllUser();
                Log.e("lin",entities.toString());
            }
        });
    }
}
