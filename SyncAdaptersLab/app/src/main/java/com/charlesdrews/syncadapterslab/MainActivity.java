package com.charlesdrews.syncadapterslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String FACEBOOK = "http://dev.markitondemand.com/MODApis/Api/v2/Quote?symbol=fb";
    private String DISNEY = "http://dev.markitondemand.com/MODApis/Api/v2/Quote?symbol=dis";
    private String MARATHON_OIL = "http://dev.markitondemand.com/MODApis/Api/v2/Quote?symbol=mro";
    private String MONSANTO = "http://dev.markitondemand.com/MODApis/Api/v2/Quote?symbol=mon";
    private String BOFA = "http://dev.markitondemand.com/MODApis/Api/v2/Quote?symbol=bac";

    Button mSyncNowButton;
    Button mOneMinuteButton;
    Button mFiveMinuteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSyncNowButton = (Button) findViewById(R.id.manualButton);
        mOneMinuteButton = (Button) findViewById(R.id.minuteButton);
        mFiveMinuteButton = (Button) findViewById(R.id.fiveMinuteButton);

        mSyncNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mOneMinuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mFiveMinuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
