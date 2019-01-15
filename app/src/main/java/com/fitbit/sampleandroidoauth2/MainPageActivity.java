package com.fitbit.sampleandroidoauth2;


import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.IntentService;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.icu.text.SimpleDateFormat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class MainPageActivity extends Activity {//AppCompatActivity {
    private String v_person= "Ranjan";//getString();
    private long v_activity_steps= 15000;//Integer.valueOf(getString());
    private long v_redeemed_steps= 0;//Integer.valueOf(getString());
    private Date v_today_dt= new Date();

    //Added by Ranjan
    public static Intent newIntent(Context context) {
        return new Intent(context, MainPageActivity.class);
    }
    //Added by Ranjan
    globals stepGlobalInstance = globals.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //Added by Ranjan



       //Getstepfunction ();
        //addTabs();

        v_activity_steps = stepGlobalInstance.getSteps();
       // v_activity_steps = summary.getSteps();
        ////---


        final TextView TodayStepsTextView = (TextView) findViewById(R.id.textView_today_steps);
        final TextView TotalRedeemedStepsTextView = (TextView) findViewById(R.id.textView_total_redeemed_steps);
        final TextView StepsAvailRedeemTextView = (TextView) findViewById(R.id.textView_steps_available_for_redeem);
        Button RedeemButton = (Button) findViewById(R.id.button_redeem);
        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView_login_click_2);
        textView.setText("Welcome "+v_person.toString());
        TodayStepsTextView.setText("Today's Steps... "+String.valueOf(v_activity_steps));
        TotalRedeemedStepsTextView.setText("Total Redeemed Steps... "+String.valueOf(v_redeemed_steps));
        StepsAvailRedeemTextView.setText("Steps Available For Redeem... "+String.valueOf(v_activity_steps-v_redeemed_steps));
        RedeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_redeemed_steps=v_redeemed_steps+2000;
                v_activity_steps=v_activity_steps-v_redeemed_steps;
                TodayStepsTextView.setText("Today's Steps... "+String.valueOf(v_activity_steps));
                TotalRedeemedStepsTextView.setText("Total Redeemed Steps... "+String.valueOf(v_redeemed_steps));
                StepsAvailRedeemTextView.setText("Steps Available For Redeem... "+String.valueOf(v_activity_steps-v_redeemed_steps));

            }
        });
    }






}
