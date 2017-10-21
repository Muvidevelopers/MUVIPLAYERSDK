package com.muvi.muviplayersdkdemo;

import android.app.Application;

import com.muvi.muviplayersdk.chromecast.ChromeCastApplicationId;


/**
 * Created by MUVI on 12-Oct-17.
 */

public class SetUpAppId extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ChromeCastApplicationId.chromeCastID="49A4D3B2";
    }
}
