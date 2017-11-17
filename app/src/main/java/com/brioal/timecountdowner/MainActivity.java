package com.brioal.timecountdowner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.brioal.countdowner.TimeCounter;

public class MainActivity extends AppCompatActivity {
    private Button mBtnList;
    private TimeCounter mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnList = (Button) findViewById(R.id.main_btn_list);
        mCounter = (TimeCounter) findViewById(R.id.main_counter);
        mCounter.setWithOutZero(true);
        mCounter.setStatic(true);
        mCounter.setmTimeLeft(25 * 60);
        mCounter.build();
        mBtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
