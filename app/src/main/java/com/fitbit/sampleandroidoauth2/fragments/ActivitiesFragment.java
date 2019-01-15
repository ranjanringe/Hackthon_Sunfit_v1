package com.fitbit.sampleandroidoauth2.fragments;


import com.fitbit.api.loaders.ResourceLoaderResult;
import com.fitbit.api.models.Activities;
import com.fitbit.api.models.DailyActivitySummary;
import com.fitbit.api.models.Goals;
import com.fitbit.api.models.Summary;
import com.fitbit.api.services.ActivityService;
import com.fitbit.sampleandroidoauth2.MainPageActivity;
import com.fitbit.sampleandroidoauth2.R;
import com.fitbit.sampleandroidoauth2.UserDataActivity;
import com.fitbit.sampleandroidoauth2.globals;

import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;

import java.util.Date;

/**
 * Created by jboggess on 10/17/16.
 */

public class ActivitiesFragment extends InfoFragment<DailyActivitySummary> {

    @Override
    public int getTitleResourceId() {
        return R.string.activity_info;
    }

    @Override
    protected int getLoaderId() {
        return 3;
    }

    @Override
    public Loader<ResourceLoaderResult<DailyActivitySummary>> onCreateLoader(int id, Bundle args) {
        return ActivityService.getDailyActivitySummaryLoader(getActivity(), new Date());

    }




    @Override
    public void onLoadFinished(Loader<ResourceLoaderResult<DailyActivitySummary>> loader, ResourceLoaderResult<DailyActivitySummary> data) {
        super.onLoadFinished(loader, data);
        if (data.isSuccessful()) {
            bindActivityData(data.getResult());
        }
    }





    public void bindActivityData(DailyActivitySummary dailyActivitySummary) {
        StringBuilder stringBuilder = new StringBuilder();

        Summary summary = dailyActivitySummary.getSummary();

        //Commented and added by Ranjan

        globals stepGlobalInstance = globals.getInstance();
        stepGlobalInstance.setSteps(summary.getSteps());

        //Goals goals = dailyActivitySummary.getGoals();


        //stringBuilder.append("<b>TODAY</b> ");
        //stringBuilder.append("<br />");
        //stringBuilder.append("Steps : " + summary.getSteps() );
        stringBuilder.append("Today's Step  : " + stepGlobalInstance.getSteps() );
        //stringBuilder.append("R");
        //printKeys(stringBuilder, summary);
        //printKeys(stringBuilder, summary.getSteps());

       /* stringBuilder.append("<br /><br />");
        stringBuilder.append("<b>GOALS</b> ");
        stringBuilder.append("<br />");
        printKeys(stringBuilder, goals); */

        setMainText(stringBuilder.toString());
    }
}
