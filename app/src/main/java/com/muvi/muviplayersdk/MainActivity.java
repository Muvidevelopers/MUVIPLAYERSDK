package com.muvi.muviplayersdk;

import android.content.Intent;
import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.muvi.muviplayersdk.activity.ExoPlayerActivity;
import com.muvi.muviplayersdk.activity.Player;
import com.muvi.muviplayersdk.utils.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Player playerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerModel=new Player();


        // Compulsory inputs for Player //

        // NON-DRM Url
        playerModel.setVideoUrl("https://r2---sn-5hne6n7z.googlevideo.com/videoplayback?ei=Xz_bWY6BM5OB1gLwyJKABw&lmt=1456261570338314&ipbits=0&ratebypass=yes&expire=1507562432&requiressl=yes&itag=18&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mm=31&ip=37.58.82.169&mn=sn-5hne6n7z&mime=video%2Fmp4&ms=au&signature=2341B8D4A24F4A6C292F2519B84842B6B20FEB2A.53D053FF750B312B46423570FA2B1BBE5CAC2771&source=youtube&mv=m&initcwndbps=9390000&id=o-AJ6qgc1F3hvVHycxJdCAjCaoO-I0OwSu9G7LKh5TUOKb&pl=20&key=yt6&dur=148.236&mt=1507540682&title=The+Most+Satisfying+Video+In+The+World+PART+2.mp4");
        // DRM Url
        //playerModel.setVideoUrl("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWl2ABAe2Dh-9TM6dhJAmG5sx6PzAIA2d943WTbc8mk6roj0y7BniqrgszpHL7FZAXdL8uHRAvYZwFwWy7NsSiAEz9xF5MS34RHloYcZmZWawmx58fB-CwO1oEySMKDMZUb-i3T061UfO6wEG3YgxaLJtmsBFKmC9VSGGz-IWi_W3bRUpefuK_LrpUPYlaBhpumnHTt5gQAAABRsWf9ZadhLZhUJMLYky_sT-JNaSg#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");

        playerModel.setStreamUniqueId("cd222bdc2af51646483a4ae9271074b6");
        playerModel.setMovieUniqueId("b3acd62aaa10103ae0e9cea9f031ac54");
        playerModel.setUserId("151404");
        playerModel.setEmailId("bb@gmail.com");
        playerModel.setAuthTokenStr("25e74a5c88d19c4b57c8138bf47abdf7");
        playerModel.setAppName(getResources().getString(com.example.muviplayersdk.R.string.app_name));

        // If the contnet is a single part
        playerModel.setEpisode_id("0");
        // If the contnet is a multi part
//        playerModel.setEpisode_id("cd222bdc2af51646483a4ae9271074b6"); // set stream unique id as episode id

        // ***************** END *************//

        // Opational inputs for player //

        playerModel.setVideoTitle("Humanima - Gorillas And Men");
        playerModel.setVideoStory("This series explores the world of men and women who have forged a unique bond with wildlife and nature. They have dedicated their lives to their passion. They care deeply about the protection of the environment and share a common desire for the preservation of animal life. They make us realize that we can respect and share our world with other species.\n");
        playerModel.setVideoGenre("DOCUMENTARY , ENGLISH");
        playerModel.setVideoDuration("00:23:41");
        playerModel.setVideoReleaseDate("");
        playerModel.setCensorRating("");
        playerModel.setVideoResolution("360");

        //************** End ************//



        // Inputs for subtitle support in player (OPTIONAL) //
        // Note : Subtitle path should be a physical path of downloaded subtitle file .
        // Note : Subtitle file should be in .vtt format .

        ArrayList<String> subtitleName=new ArrayList<String>();
        subtitleName.add("English");
        subtitleName.add("Hindi");
        subtitleName.add("Spanish");

        ArrayList<String> subtitlepath=new ArrayList<String>();
        subtitlepath.add("android/sdcard/sdcard0/subtitle_path/english.vtt");
        subtitlepath.add("android/sdcard/sdcard0/subtitle_path/hindi.vtt");
        subtitlepath.add("android/sdcard/sdcard0/subtitle_path/spanish.vtt");

        playerModel.setSubTitleName(subtitleName);
        playerModel.setSubTitlePath(subtitlepath);

        //********** END *****************//



        // Inputs for subtitle support in chromecast (OPTIONAL) //
        // Note : Subtitle path should be a URL .
        // Note : Subtitle file should be in .vtt format .

        ArrayList<String> chromecast_subtitle_language=new ArrayList<String>();
        chromecast_subtitle_language.add("English");
        chromecast_subtitle_language.add("Hindi");
        chromecast_subtitle_language.add("Spanish");

        ArrayList<String> chromecast_subtitle_url=new ArrayList<String>();
        chromecast_subtitle_url.add("https://www.muvi.com/english.vtt");
        chromecast_subtitle_url.add("https://www.muvi.com/hindi.vtt");
        chromecast_subtitle_url.add("https://www.muvi.com/spanish.vtt");

        ArrayList<String> chromecast_subtitle_code=new ArrayList<String>();
        chromecast_subtitle_url.add("en");
        chromecast_subtitle_url.add("hi");
        chromecast_subtitle_url.add("nl");


        playerModel.setChromecsatSubtitleUrl(chromecast_subtitle_url);
        playerModel.setChromecsatSubtitleLanguage(chromecast_subtitle_language);
        playerModel.setChromecsatSubtitleLanguageCode(chromecast_subtitle_code);

        //********** END *****************//

        // Inputs for resolution change for NON-DRM video (OPTIONAL) //

        ArrayList<String> resolutionFormat = new ArrayList<String>();
        resolutionFormat.add("BEST");
        resolutionFormat.add("720p");
        resolutionFormat.add("360p");
        resolutionFormat.add("144p");

        ArrayList<String> resolutionUrl = new ArrayList<String>();
        resolutionUrl.add("http://www.example.com/1080/finny.mp4");
        resolutionUrl.add("http://www.example.com/720/finny.mp4");
        resolutionUrl.add("http://www.example.com/360/finny.mp4");
        resolutionUrl.add("http://www.example.com/144/finny.mp4");

        playerModel.setResolutionFormat(resolutionFormat);
        playerModel.setResolutionUrl(resolutionUrl);

        //********** END *****************//


        Intent playerIntent=new Intent(MainActivity.this,ExoPlayerActivity.class);
        playerIntent.putExtra("PlayerModel",playerModel);
        startActivity(playerIntent);
    }
}
