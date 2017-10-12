package com.muvi.muviplayersdk;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.print.PrintAttributes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.muvi.muviplayersdk.activity.ExoPlayerActivity;
import com.muvi.muviplayersdk.activity.Player;
import com.muvi.muviplayersdk.utils.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Player playerModel;

    RadioButton drm,non_drm,live;
    CheckBox subtitle,resolution;
    FloatingActionButton fab;
    Spinner select_video;
    ArrayAdapter adapter;
    String Video_Name = "";
    Toolbar toolbar;

    ArrayList<String> url_name= new ArrayList();
    ArrayList<String> url= new ArrayList();

    ArrayList<String> subtitleName=new ArrayList<String>();
    ArrayList<String> subtitlepath=new ArrayList<String>();

    ArrayList<String> chromecast_subtitle_language=new ArrayList<String>();
    ArrayList<String> chromecast_subtitle_url=new ArrayList<String>();
    ArrayList<String> chromecast_subtitle_code=new ArrayList<String>();

    ArrayList<String> resolutionFormat = new ArrayList<String>();
    ArrayList<String> resolutionUrl = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drm = (RadioButton) findViewById(R.id.drm);
        non_drm = (RadioButton) findViewById(R.id.non_drm);
        live = (RadioButton) findViewById(R.id.live);
        subtitle = (CheckBox) findViewById(R.id.subtitle);
        resolution = (CheckBox) findViewById(R.id.resolution);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        select_video = (Spinner) findViewById(R.id.select_video);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("Player SDK");
        toolbar.setTitleTextColor(Color.WHITE);


        playerModel=new Player();





        url_name.add("-----Select Video----");
        url_name.add("Test DRM");
        url_name.add("Test Multi-Bitrate");

        url.add("");
        url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWk0ABAXqtqxZIeuiWUN9l9mbXB4AIDCbwk9Y-aGbq6OwM-9LMasc4yzQ8iuzJqVbdLipch4EQQUsaX1lHs-OYwgKBfsHnmIb0IME_Zh2bLw7mXvix5X2J3fIBvkmuIPbK-xIfEOBI34LOysPqEHnt3v1G6XETMziD81Yi29B5AKpsVIlpd_wzz4Kr6DtWZGE8bhnaoakgAAABQ4YkEXOKSeIspx0wDapcCGX3s9cw#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");
        url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWlVABCzoGQnnGqqVx8CU6MPdoiEAIALFM-xf8G3Y43a95Ol3GaIb5xOfxXJNJhDJYyiqtQs6uVityl2HeHRpLLJtTMkC7KrIBjjrJvkxZ_2klWKXfimeQ9gOuUwEq080u-QsBr77TRKn7T4MnkV_3PzAYtfIkAbDf2qHzNK5wDCRgMfOfZyG0hF1CDEAxiNtd653zgeGQAAABT7_rDnurt8p3R1jEd4u8IP_sfOoA#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F93913%2Fstream.mpd");

        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,url_name);
        select_video.setAdapter(adapter);


        drm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_name.clear();
                url.clear();

                url_name.add("-----Select Video----");
                url_name.add("Test DRM");
                url_name.add("Test Multi-Bitrate");

                url.add("");
                url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWk0ABAXqtqxZIeuiWUN9l9mbXB4AIDCbwk9Y-aGbq6OwM-9LMasc4yzQ8iuzJqVbdLipch4EQQUsaX1lHs-OYwgKBfsHnmIb0IME_Zh2bLw7mXvix5X2J3fIBvkmuIPbK-xIfEOBI34LOysPqEHnt3v1G6XETMziD81Yi29B5AKpsVIlpd_wzz4Kr6DtWZGE8bhnaoakgAAABQ4YkEXOKSeIspx0wDapcCGX3s9cw#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");
                url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWlVABCzoGQnnGqqVx8CU6MPdoiEAIALFM-xf8G3Y43a95Ol3GaIb5xOfxXJNJhDJYyiqtQs6uVityl2HeHRpLLJtTMkC7KrIBjjrJvkxZ_2klWKXfimeQ9gOuUwEq080u-QsBr77TRKn7T4MnkV_3PzAYtfIkAbDf2qHzNK5wDCRgMfOfZyG0hF1CDEAxiNtd653zgeGQAAABT7_rDnurt8p3R1jEd4u8IP_sfOoA#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F93913%2Fstream.mpd");

                adapter.notifyDataSetChanged();
                select_video.setSelection(0);
            }
        });

        non_drm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_name.clear();
                url.clear();

                url_name.add("-----Select Video----");
                url_name.add("Dance plus");
                url_name.add("FRIENDS");

                url.add("");
                url.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/uploads/movie_stream/full_movie/103462/Dance_plus_242.mp4?Expires=1507778254&Signature=LGPXxyfAP8a~iMaiJ4RbSYhSzoY3PVAF4e-~RFp6gniDXUxz15wx5StYzw1whUPgQJA-U8LRhYfTDk0SrxWn3TJBgj72eofkgBWxbGBo2YoU5lDN4VzqQqmrOEy6iupTnn8bUh2VwiSm7CrLMfxUbiFChhIKYxpWpFSgXz7B49dgo3F4jUfM~dZn3EXOuv0j6vP5w5KpwnBPbg88r12hGzEuVCrIf2hEHtZ9CZ~F-cZCWYu8FJkAhxYU1-wYBAqMFPidszpZ5bGRWBwVZe73-MJjOwR33Gp1fgmgsJqJYkI-sLqgzBFdpLJGl23uwrb7lBTY2bMwA9cRo9t2hjjs1g__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");
                url.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/uploads/movie_stream/full_movie/103461/Friends___Ross___Rachel___We_never_had_bonus_night__242.mp4?Expires=1507778311&Signature=RgCEFTC5N4ab9JNP2Jq7TlcvQV8It~MVVp2kWuVmo9baz864dI040~6Yegs3gpB4Ne2CbYNrCB9UnM5JUCbJEBxgowdcEtG36z-G4bpO4EPyul6NxuXo03QKDyYnKT1oojUFKulJD~nKvOWInWWLt3BGscV7pYB68bvDibNbgGo4d-heZkzeNmp~23r0lRT2gys9LgOgQU-1lDOAQp690Hinb0rrHNsrYQF33zSpQ614Lx1uZ~OU9E7sSS~BSS0GG7nEC517rGaBdX9KhVMaZbz2M75AfJwNVHEwn2FAjY0TLNyJn8JA4LcbkhUkt-y1pKoumJ17TnPK1tl82wjdtw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");

                adapter.notifyDataSetChanged();
                select_video.setSelection(0);

            }
        });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url_name.clear();
                url.clear();

                url_name.add("-----Select Video----");
                url_name.add("Sanjay Test LS");

                url.add("");
                url.add("https://bcsecurelivehls-i.akamaihd.net/hls/live/261547/1539097700001/master_720p.m3u8");

                adapter.notifyDataSetChanged();
                select_video.setSelection(0);

            }
        });

        subtitle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if(isChecked){
                    subtitleName.clear();
                    subtitlepath.clear();

                    subtitleName.add("English");
                    subtitleName.add("Telgu");

                    subtitlepath.add("/storage/emulated/0/Android/data/DemoSubtitle/1507711895296.vtt");
                    subtitlepath.add("/storage/emulated/0/Android/data/DemoSubtitle/1507711896448.vtt");

                }
                else {
                    subtitleName.clear();
                    subtitlepath.clear();
                }

                playerModel.setSubTitleName(subtitleName);
                playerModel.setSubTitlePath(subtitlepath);

            }
        });

        resolution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    resolutionFormat.clear();
                    resolutionUrl.clear();

                    resolutionFormat.add("720p");
                    resolutionFormat.add("144p");

                    resolutionUrl.add("https://r2---sn-q4fl6ne6.googlevideo.com/videoplayback?id=o-AHDLj3j1y4yQ869UykWPgRQyEHx8EdhCwXJH29nlTDzc&dur=370.845&expire=1507733965&pl=24&source=youtube&sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mv=u&ipbits=0&requiressl=yes&ms=au&ip=159.253.144.86&mm=31&mn=sn-q4fl6ne6&lmt=1507244073185437&ratebypass=yes&itag=22&mt=1507711878&ei=bd3dWeuPGJGH1gLC65GIDQ&key=yt6&mime=video%2Fmp4&signature=7D11A4E0F2C332E5EDAEF1AAEBFCC333AE6AA0E0.9B26F7368C4CDB55547924E9407F1B5FDD8D1551&title=Our+Story+in+6+Minutes.mp4");
                    resolutionUrl.add("https://r2---sn-q4fl6ne6.googlevideo.com/videoplayback?id=o-AHDLj3j1y4yQ869UykWPgRQyEHx8EdhCwXJH29nlTDzc&dur=370.869&expire=1507733965&pl=24&source=youtube&sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&mv=u&ipbits=0&requiressl=yes&ms=au&ip=159.253.144.86&mm=31&mn=sn-q4fl6ne6&lmt=1500088043012092&itag=17&mt=1507711878&ei=bd3dWeuPGJGH1gLC65GIDQ&key=yt6&mime=video%2F3gpp&signature=97206D79287A269F7EFFB90296E8E5732A974DE7.0D42998BAC1DA42F59075BC41C5A911AF785A27E&title=Our+Story+in+6+Minutes&ratebypass=yes.3gp");

                }else
                {
                    resolutionFormat.clear();
                    resolutionUrl.clear();
                }

                playerModel.setResolutionFormat(resolutionFormat);
                playerModel.setResolutionUrl(resolutionUrl);

            }
        });

        select_video.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Video_Name = select_video.getSelectedItem().toString().trim();

                if(position!=0)
                {
                    playerModel.setVideoUrl(url.get(position));
                    playerModel.setUserId("151404");
                    playerModel.setEmailId("bb@gmail.com");
                    playerModel.setAuthTokenStr("25e74a5c88d19c4b57c8138bf47abdf7");
                    playerModel.setAppName(getResources().getString(com.example.muviplayersdk.R.string.app_name));

                    playerModel.setEpisode_id("0"); // Single part
//                  playerModel.setEpisode_id("set stream id here"); // multi part

                    playerModel.setVideoTitle("Humanima - Gorillas And Men");
                    playerModel.setVideoStory("This series explores the world of men and women who have forged a unique bond with wildlife and nature. They have dedicated their lives to their passion. They care deeply about the protection of the environment and share a common desire for the preservation of animal life. They make us realize that we can respect and share our world with other species.\n");
                    playerModel.setVideoGenre("DOCUMENTARY , ENGLISH");
                    playerModel.setVideoDuration("00:23:41");
                    playerModel.setVideoReleaseDate("");
                    playerModel.setCensorRating("");



                    if(live.isChecked())
                        playerModel.setContentTypesId(4);
                    //add

                    if(Video_Name.contains("Test DRM")){

                        playerModel.setStreamUniqueId("cd222bdc2af51646483a4ae9271074b6");
                        playerModel.setMovieUniqueId("b3acd62aaa10103ae0e9cea9f031ac54");

                    }
                    if(Video_Name.contains("Test Multi-Bitrate")){

                        playerModel.setStreamUniqueId("d10a4a2361493ef9de4fa1b295f4c5dd");
                        playerModel.setMovieUniqueId("4ebec86526cfdced230668703da0dd03");

                    }

                    if(Video_Name.contains("Dance plus")){

                        playerModel.setStreamUniqueId("c649c544153950c2ef6bd88e66f64dd1");
                        playerModel.setMovieUniqueId("c313c89bbfeaac4b04ed1f0d199f754e");

                    }
                    if(Video_Name.contains("FRIENDS")){

                        playerModel.setStreamUniqueId("83697330594d1e8aade23cc07e4bd4a9");
                        playerModel.setMovieUniqueId("2bef73e66b216cff66dfacdd654eeacb");

                    }
                    if(Video_Name.contains("Sanjay Test LS")){

                        playerModel.setStreamUniqueId("2e2dbf71c6dfea51117b556befd4bdf3");
                        playerModel.setMovieUniqueId("a88175c63844102fca4ea2c68202f112");
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},111);
                    }
                    else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                111);
                    }
                }
                else{

                    NavigateToPlayer();
                }
            }
        });

/*


        // Mandatory inputs for Player //

        // NON-DRM Url
        //playerModel.setVideoUrl("https://r2---sn-5hne6n7z.googlevideo.com/videoplayback?ei=Xz_bWY6BM5OB1gLwyJKABw&lmt=1456261570338314&ipbits=0&ratebypass=yes&expire=1507562432&requiressl=yes&itag=18&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mm=31&ip=37.58.82.169&mn=sn-5hne6n7z&mime=video%2Fmp4&ms=au&signature=2341B8D4A24F4A6C292F2519B84842B6B20FEB2A.53D053FF750B312B46423570FA2B1BBE5CAC2771&source=youtube&mv=m&initcwndbps=9390000&id=o-AJ6qgc1F3hvVHycxJdCAjCaoO-I0OwSu9G7LKh5TUOKb&pl=20&key=yt6&dur=148.236&mt=1507540682&title=The+Most+Satisfying+Video+In+The+World+PART+2.mp4");
        // DRM Url
        //playerModel.setVideoUrl("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWl2ABAe2Dh-9TM6dhJAmG5sx6PzAIA2d943WTbc8mk6roj0y7BniqrgszpHL7FZAXdL8uHRAvYZwFwWy7NsSiAEz9xF5MS34RHloYcZmZWawmx58fB-CwO1oEySMKDMZUb-i3T061UfO6wEG3YgxaLJtmsBFKmC9VSGGz-IWi_W3bRUpefuK_LrpUPYlaBhpumnHTt5gQAAABRsWf9ZadhLZhUJMLYky_sT-JNaSg#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");
        //live Stream
        playerModel.setVideoUrl("  https://d2vo3ozpc06skj.cloudfront.net/c31-tv-1501124096/index.m3u8");
        playerModel.setContentTypesId(4);
        playerModel.setStreamUniqueId("cd222bdc2af51646483a4ae9271074b6");
        playerModel.setMovieUniqueId("b3acd62aaa10103ae0e9cea9f031ac54");
        playerModel.setUserId("151404");
        playerModel.setEmailId("bb@gmail.com");
        playerModel.setAuthTokenStr("25e74a5c88d19c4b57c8138bf47abdf7");
        playerModel.setAppName(getResources().getString(com.example.muviplayersdk.R.string.app_name));

        // If the contnet is a single part
        playerModel.setEpisode_id("0");
        // If the contnet is a multi part
        //playerModel.setEpisode_id("cd222bdc2af51646483a4ae9271074b6"); // set stream unique id as episode id

        // ***************** END *************//*/

        // Opational inputs for player //

        playerModel.setVideoTitle("Humanima - Gorillas And Men");
        playerModel.setVideoStory("This series explores the world of men and women who have forged a unique bond with wildlife and nature. They have dedicated their lives to their passion. They care deeply about the protection of the environment and share a common desire for the preservation of animal life. They make us realize that we can respect and share our world with other species.\n");
        playerModel.setVideoGenre("DOCUMENTARY , ENGLISH");
        playerModel.setVideoDuration("00:23:41");
        playerModel.setVideoReleaseDate("");
        playerModel.setCensorRating("");
        playerModel.setVideoResolution("360");

        /*//************** End ************//*/



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

        /*//********** END *****************//*/



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

        /*//********** END *****************//*/

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

        /*//********** END *****************//*/


        Intent playerIntent=new Intent(MainActivity.this,ExoPlayerActivity.class);
        playerIntent.putExtra("PlayerModel",playerModel);
        startActivity(playerIntent);*/
    }

    public void NavigateToPlayer(){
        if(Video_Name.contains("-----Select Video----")){
            Toast.makeText(getApplicationContext(),"Please Select A Video.",Toast.LENGTH_LONG).show();
            return;
        }

        Intent playerIntent=new Intent(MainActivity.this,ExoPlayerActivity.class);
        playerIntent.putExtra("PlayerModel",playerModel);
        startActivity(playerIntent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 111: {

                if (grantResults.length > 0) {
                    if ((grantResults.length > 0) && (grantResults[0]) == PackageManager.PERMISSION_GRANTED) {
                        //Call whatever you want
                        NavigateToPlayer();
                    } else {
                        finish();
                    }
                } else {
                    finish();
                }

                return;
            }
        }
    }
}
