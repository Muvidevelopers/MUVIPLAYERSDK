package com.muvi.muviplayersdkdemo;

import android.app.Application;
import android.util.Log;

import com.muvi.muviplayersdk.activity.CastCrew;
import com.muvi.muviplayersdk.chromecast.ChromeCastApplicationId;


/**
 * Created by MUVI on 12-Oct-17.
 */

public class SetUpAppId extends Application implements CastCrew.AppInterface {


    @Override
    public void onCreate() {
        super.onCreate();
        ChromeCastApplicationId.chromeCastID="49A4D3B2";
    }


    SetUpAppId() {
        CastCrew.registerApp(this);
    }

    @Override
    public void getCastCrewDetails(String movie_id) {
        // Call Cast & Crew Activity.

        Log.v("BIBHU11","APPLICATION CALLED--"+movie_id);
        // Do what ever you want.

    }
}
