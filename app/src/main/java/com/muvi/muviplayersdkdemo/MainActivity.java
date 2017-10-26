package com.muvi.muviplayersdkdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.muvi.muviplayersdk.activity.ExoPlayerActivity;
import com.muvi.muviplayersdk.activity.MyDownloads;
import com.muvi.muviplayersdk.activity.Player;
import com.muvi.muviplayersdk.model.DownloadModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Player playerModel;

    RadioButton drm, non_drm, live;
    CheckBox subtitle, resolution, chromecast, watermark,offline,ip,email,date;
    FloatingActionButton fab,my_fab;
    Spinner select_video;
    ArrayAdapter adapter;
    String Video_Name = "";
    Toolbar toolbar;
    LinearLayout watermark_details;

    ArrayList<String> url_name = new ArrayList();
    ArrayList<String> url = new ArrayList();

    ArrayList<String> subtitleName = new ArrayList<String>();
    ArrayList<String> subtitlepath = new ArrayList<String>();

    ArrayList<String> chromecast_subtitle_language = new ArrayList<String>();
    ArrayList<String> chromecast_subtitle_url = new ArrayList<String>();
    ArrayList<String> chromecast_subtitle_code = new ArrayList<String>();

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
        chromecast = (CheckBox) findViewById(R.id.chromecast);
        watermark = (CheckBox) findViewById(R.id.watermark);
        watermark_details = (LinearLayout) findViewById(R.id.watermark_details);
        offline = (CheckBox) findViewById(R.id.offline);
        ip = (CheckBox) findViewById(R.id.ip);
        email = (CheckBox) findViewById(R.id.email);
        date = (CheckBox) findViewById(R.id.date);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        my_fab = (FloatingActionButton) findViewById(R.id.my_fab);
        select_video = (Spinner) findViewById(R.id.select_video);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("Player SDK");
        toolbar.setTitleTextColor(Color.WHITE);


        playerModel = new Player();


        url_name.add("-----Select Video----");
        url_name.add("Test DRM");
        url_name.add("Test Multi-Bitrate");

        url.add("");
        url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWk0ABAXqtqxZIeuiWUN9l9mbXB4AIDCbwk9Y-aGbq6OwM-9LMasc4yzQ8iuzJqVbdLipch4EQQUsaX1lHs-OYwgKBfsHnmIb0IME_Zh2bLw7mXvix5X2J3fIBvkmuIPbK-xIfEOBI34LOysPqEHnt3v1G6XETMziD81Yi29B5AKpsVIlpd_wzz4Kr6DtWZGE8bhnaoakgAAABQ4YkEXOKSeIspx0wDapcCGX3s9cw#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");
        url.add("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWlVABCzoGQnnGqqVx8CU6MPdoiEAIALFM-xf8G3Y43a95Ol3GaIb5xOfxXJNJhDJYyiqtQs6uVityl2HeHRpLLJtTMkC7KrIBjjrJvkxZ_2klWKXfimeQ9gOuUwEq080u-QsBr77TRKn7T4MnkV_3PzAYtfIkAbDf2qHzNK5wDCRgMfOfZyG0hF1CDEAxiNtd653zgeGQAAABT7_rDnurt8p3R1jEd4u8IP_sfOoA#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F93913%2Fstream.mpd");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, url_name);
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
                url.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/uploads/movie_stream/full_movie/103462/Dance_plus_242.mp4?Expires=1508369918&Signature=QpZE8I0VQZ9V6MXxfU3FAuq7Sv79~tTShasmSRTu61d4lBWZeVsGU3BKLgHCYCGshNMU2~fphmg9VJ6OFALKmX4E6mN3Y7BYxAuSV7JaYDsqYdEZIV-Y1AvY8m5LAgQmPfuKGh3YgxJjtr-QeHfNg3vtTrSEvpTp~L3G1QqGIq9WoOnAqetWq6H3HpOqaGgvNwKfpz~lt5wm0H7WU0w36f3j92wjwOdJiiynFomOiHYNVcKDICtYUcfYEzU6cokHlhO5KCwUWPMGYIcjB6zRiGIG~bmGbaTIau0BudmSTxkQ--iJXyCwWyw3yXj~qTOPgl~6ZrW0LgjEesLGNU7JdQ__&Key-Pair-Id=APKAJYIDWFG3D6CNOYV");
                url.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/uploads/movie_stream/full_movie/103461/Friends___Ross___Rachel___We_never_had_bonus_night__480.mp4?Expires=1508369782&Signature=RWwnDXQyzUY8XHTA0PhXmxyuAnmNdj1DKtU-Fkp27FJRcCeGJmKur8oqDlJdbDdWKDaxBc~ckr9DxX-TeBngMtW1p70NDPkSAil61YIzhZZKb231rta0nPxYs2S2yXwz1g-XiltdVevthBQUDHIthN8Q1G6YLVCcNNABlAvEZSydUH2LT5BiB54EHY8ojXG-UdPvWMapODkI8FsIW4nFFf0XiQ7qDGMwhEmega~Wu~OdWwIQqwgqe1w5qEJ5EsQNwt3GJOuSmMCdN0RPx1psmo9nsGYPd9gjgemGto9fG5qJIot88~uRy-vs0hrJ467gy1Z3VK1hOoMaDNkELH9tRA__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");

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


                if (isChecked) {
                    subtitleName.clear();
                    subtitlepath.clear();

                    subtitleName.add("English");
                    subtitleName.add("Telgu");

                    subtitlepath.add("/storage/emulated/0/Android/data/DemoSubtitle/1507711895296.vtt");
                    subtitlepath.add("/storage/emulated/0/Android/data/DemoSubtitle/1507711896448.vtt");

                    chromecast_subtitle_language.clear();
                    chromecast_subtitle_url.clear();
                    chromecast_subtitle_code.clear();

                    chromecast_subtitle_language.add("English");
                    chromecast_subtitle_language.add("Telgu");

                    chromecast_subtitle_url.add(" https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/subtitle/3119/test.vtt?Expires=1507935854&Signature=g57fQOUzBfLjSM03xXSxhesMHfqJBKyPH9CcbAfhW5cz5-vZ~9MNIcQJKqDvVvxNE9yrddHcqOS6oCl-g-cM85h4B8Wd1pEfAhOF3~Y4JpfL4GnEEDvy2b53V8qXxy0KCdPSi-UIUZiRas0AlTTEjhuEcb~lUbnGGIs0DD4I5IIUxESq6iewX-boZyzwz6Kb7mQpZhnj9jr7MGFgq8YxlQCJEuqt2tGrn~9fg-AoOEe4OGkH9IODlbU7jgkmqrYyryFr9qxLDhkECohBTNZYprHuZo0Et0xiBRCsoPOuIk8FBLLcjAzQ6Iqq1B~mMft5M8BE0zo~zEPrXJldhwguGw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");
                    chromecast_subtitle_url.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/subtitle/3120/telugu.vtt?Expires=1507935854&Signature=b5xIHGXsVXSkiqNI~EfBaSuAUhF8eBTYrl0nObNBKGsS286B0BkM7T-fF2V8~28-PZ~aPxAWjRn1P~e6bFud~hFtCKCnx76HfF9p3eeUBQZe3J0gD6ArF~nw0KtxGu-oNYAmUUQgFBafrFum28QB1fU8KjlGfL12w-XV6UbOBVyaytlMbne5HTag9yx1fGIivzbpSSPEg~SVu1bCfaMSPmedJEBkOkP2aq2IOv5Jc~lfV0MqX8mdjUYuRnE2ifOB7SeNKo3NCaMYRntWqlKjU9TxsmrjaufCLWvayiXpT7vhXi-PvIzL-bhiXwmtQo~8Xt3Z3am6jfu8rKVR0KNJag__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");

                    chromecast_subtitle_code.add("en");
                    chromecast_subtitle_code.add("te");


                    playerModel.setChromecsatSubtitleUrl(chromecast_subtitle_url);
                    playerModel.setChromecsatSubtitleLanguage(chromecast_subtitle_language);
                    playerModel.setChromecsatSubtitleLanguageCode(chromecast_subtitle_code);


                } else {
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

                if (isChecked) {
                    resolutionFormat.clear();
                    resolutionUrl.clear();

                    resolutionFormat.add("720p");
                    resolutionFormat.add("144p");

                    resolutionUrl.add("https://r9---sn-5hne6nse.googlevideo.com/videoplayback?initcwndbps=1480000&dur=133.468&signature=A4D3C9487EF1AACDEB63267F8DED27977BCF6E41.090AE7C8A2C8BC86508BE086C9BF6401B18138D6&nh=IgpwcjA0LmFtczE1KgkxMjcuMC4wLjE&lmt=1472402751620546&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&ei=AHTkWfabNKGH1wKov6GwCg&requiressl=yes&mime=video%2Fmp4&ip=37.58.82.168&pl=20&mn=sn-5hne6nse&mm=31&source=youtube&ms=au&id=o-ALs2qA6Y1KS55GRPl1geAgXluh0w3qCk8jGupFVtHcvQ&mv=m&mt=1508144044&expire=1508165729&key=yt6&ratebypass=yes&ipbits=0&itag=22&title=Beautiful+Nature+Video+%26+Relaxing+Music+-+Call+From+The+Past+%28HD%29.mp4");
                    resolutionUrl.add("https://r9---sn-5hne6nse.googlevideo.com/videoplayback?requiressl=yes&initcwndbps=1480000&mime=video%2F3gpp&ip=37.58.82.168&dur=133.561&pl=20&mn=sn-5hne6nse&mm=31&source=youtube&ms=au&id=o-ALs2qA6Y1KS55GRPl1geAgXluh0w3qCk8jGupFVtHcvQ&mv=m&nh=IgpwcjA0LmFtczE1KgkxMjcuMC4wLjE&mt=1508144044&expire=1508165729&signature=DEEBC717D98B3168CB621CEBE3E5B4F8EFC00001.048FBD47E336AC24755103A4971BC631B798ACB4&key=yt6&ipbits=0&lmt=1420740523637445&sparams=dur%2Cei%2Cid%2Cinitcwndbps%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cnh%2Cpl%2Crequiressl%2Csource%2Cexpire&ei=AHTkWfabNKGH1wKov6GwCg&itag=17&title=Beautiful+Nature+Video+%26+Relaxing+Music+-+Call+From+The+Past+%28HD%29&ratebypass=yes.3gp");

                } else {
                    resolutionFormat.clear();
                    resolutionUrl.clear();
                }

                playerModel.setResolutionFormat(resolutionFormat);
                playerModel.setResolutionUrl(resolutionUrl);

            }
        });

        chromecast.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    playerModel.setChromeCastEnable(true);
                } else {
                    playerModel.setChromeCastEnable(false);
                }
            }
        });

        watermark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    watermark_details.setVisibility(View.VISIBLE);
                    ip.setChecked(true);
                    date.setChecked(true);
                    email.setChecked(true);
                    playerModel.setWaterMark(true);
                } else {
                    watermark_details.setVisibility(View.GONE);
                    ip.setChecked(false);
                    date.setChecked(false);
                    email.setChecked(false);
                    playerModel.setWaterMark(false);
                }
            }
        });

        ip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    if(!email.isChecked() && !date.isChecked())
                        watermark.setChecked(false);
                }
            }
        });

        email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    if(!ip.isChecked() && !date.isChecked())
                        watermark.setChecked(false);
                }
            }
        });

        date.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    if(!email.isChecked() && !ip.isChecked())
                        watermark.setChecked(false);
                }
            }
        });


        offline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    playerModel.canDownload(true);
                    ArrayList<String> offlineSubtitleUrl = new ArrayList<>();
                    offlineSubtitleUrl.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/subtitle/3119/test.vtt?Expires=1508988656&Signature=UHOfYf3QDnPwFE1i21H3P76mEZxgAwddS0SRc6Xyo4vUiiZFyukp7-IoEARGurFwiAQHX4I0tFDvhBqK37pK-5DHrdn6L~FDoy6jNGKv9Inyzd2uKocrPiBoKuiN9GEoVy6ZMVijL0flSUpruhsRMEoqyiZjofV4Jdgcs~9upVMnD7z4K-p0OMYa54aG9zC4ZtCpiu1oPXd-8Y-KNFi8BVIyFcSVSMpDBpI4QfpRJXe7jqC4mj6k0yaCaCwKeOq41~1r3RC5Jid6OZ6ZNVsmPFDNZIgmiVYqqNVL8~0E22llb8e5CIS6u1if~quxW~enoV8Uao7h9t85NZVc5tngZw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");
                    offlineSubtitleUrl.add("https://d2l74kwt1i1y33.cloudfront.net/4050/EncodedVideo/subtitle/3120/telugu.vtt?Expires=1508988656&Signature=eDeLkOH0ECBH4WiKR3dTpDHQ8O3AdJKnW7sUHC9uytvO~aH5948vJxz9YTCZXcL6hI9Hmi5~U8Ai9XQP-IDUJ-GefzFzwi385NUu~LGZ4XQrOfwyTb3gIbND4-MpV93gC1qHl~3chu4ppP4~pjt9Ey8zHBUAn2TMU3GTDpz09jTCpxGqR3N1dxu6DhHPZ35~O~Nue3-rS4MixmfZ3Il57zsn0rx0LgLxpWtibLT8Yha32Bx07~nLegaAB4LM6Se7fMv~40t4QAIBA3-NHWTPetu12DEK5ZfnRSbQYl69QApxYc8DhTKpHk5aGX1PItsbrDF6fvx3mEls0grRHbse9g__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");

                    ArrayList<String> offlineSubtitleLanguage = new ArrayList<>();
                    offlineSubtitleLanguage.add("English");
                    offlineSubtitleLanguage.add("Telgu");


                    playerModel.setOfflineSubtitleUrl(offlineSubtitleUrl);
                    playerModel.setOfflineSubtitleLanguage(offlineSubtitleLanguage);

                } else {
                    playerModel.canDownload(false);
                }
            }
        });

        select_video.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Video_Name = select_video.getSelectedItem().toString().trim();

                if (position != 0) {
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
                    playerModel.setPlayPos(13);  // Insec

                    playerModel.setMpdVideoUrl("https://vimeoassets-singapore.s3-ap-southeast-1.amazonaws.com/4050/EncodedVideo/uploads/movie_stream/full_movie/91003/stream.mpd");
                    playerModel.setLicenseUrl("https://wv.service.expressplay.com/hms/wv/rights/?ExpressPlayToken=AwAAABSMKdwAAABgxzuIOjIrmOOVXhujA7YKU0bESAAi02zk266VkYImrkNzzXdpEFM1v6VFR-gAGNT6Nugs-G1Ef_m3n7go2KKiTrOVnzyGNqIfth0IPevI9ENxlYCBX5l_lHX6mBexN3tBXXfzYZfuczDZG95MvnQMRxWaknk");


                    if (live.isChecked())
                        playerModel.setContentTypesId(4);

                    if (Video_Name.contains("Test DRM")) {

                        playerModel.setStreamUniqueId("cd222bdc2af51646483a4ae9271074b6");
                        playerModel.setMovieUniqueId("b3acd62aaa10103ae0e9cea9f031ac54");

                    }
                    if (Video_Name.contains("Test Multi-Bitrate")) {
                        playerModel.setStreamUniqueId("d10a4a2361493ef9de4fa1b295f4c5dd");
                        playerModel.setMovieUniqueId("4ebec86526cfdced230668703da0dd03");
                    }

                    if (Video_Name.contains("Dance plus")) {

                        playerModel.setStreamUniqueId("c649c544153950c2ef6bd88e66f64dd1");
                        playerModel.setMovieUniqueId("c313c89bbfeaac4b04ed1f0d199f754e");

                    }
                    if (Video_Name.contains("FRIENDS")) {

                        playerModel.setStreamUniqueId("83697330594d1e8aade23cc07e4bd4a9");
                        playerModel.setMovieUniqueId("2bef73e66b216cff66dfacdd654eeacb");

                    }
                    if (Video_Name.contains("Sanjay Test LS")) {

                        playerModel.setStreamUniqueId("2e2dbf71c6dfea51117b556befd4bdf3");
                        playerModel.setMovieUniqueId("a88175c63844102fca4ea2c68202f112");
                    }


                    if(drm.isChecked()){

                    }
                    else if(non_drm.isChecked()){
                        ArrayList<String> nonDrmDownloadFormatList = new ArrayList<>();
                        ArrayList<String> nonDrmDownloadUrlList = new ArrayList<>();

                        nonDrmDownloadFormatList.add("144p");
                        nonDrmDownloadFormatList.add("480p");

                        nonDrmDownloadUrlList.add("https://r1---sn-q4flrney.googlevideo.com/videoplayback?sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Crequiressl%2Csource%2Cexpire&mn=sn-q4flrney&ip=159.253.144.86&source=youtube&mm=31&mv=u&mime=video%2F3gpp&expire=1508265052&ipbits=0&dur=238.794&id=o-APK7ljh-Gb86sKrU__atln_qmnvRtG8eBE0kPV4a5t61&mt=1508243387&key=yt6&lmt=1425404536869313&requiressl=yes&ms=au&ei=_PflWY26FpSd1gLCzpu4Dg&itag=17&pl=24&signature=109C0D4BC1DA0B6C50EC779C8F4B0C647B8F80DF.2FFA0576DEAD323329900CCF8A21B794DAB4E148&title=Beautiful+Nature+Video+%26+Relaxing+Music+-+Life+%28HD%29&ratebypass=yes.3gp");
                        nonDrmDownloadUrlList.add("https://r1---sn-q4flrney.googlevideo.com/videoplayback?sparams=dur%2Cei%2Cid%2Cip%2Cipbits%2Citag%2Clmt%2Cmime%2Cmm%2Cmn%2Cms%2Cmv%2Cpl%2Cratebypass%2Crequiressl%2Csource%2Cexpire&mn=sn-q4flrney&ip=159.253.144.86&source=youtube&mm=31&mv=u&mime=video%2Fmp4&expire=1508265052&ipbits=0&dur=238.585&id=o-APK7ljh-Gb86sKrU__atln_qmnvRtG8eBE0kPV4a5t61&mt=1508243387&key=yt6&lmt=1428039470911574&requiressl=yes&ms=au&ei=_PflWY26FpSd1gLCzpu4Dg&itag=18&pl=24&signature=583D7B813585AF5E52B2DF2385A106311F2CBDC5.2BECE9D23458C5F481DB22AF878068E06AC6E7C8&ratebypass=yes&title=Beautiful+Nature+Video+%26+Relaxing+Music+-+Life+%28HD%29.mp4");


                        playerModel.setNonDrmDownloadFormatList(nonDrmDownloadFormatList);
                        playerModel.setNonDrmDownloadUrlList(nonDrmDownloadUrlList);

                    }
                    else {
                        playerModel.canDownload(false);
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
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
                    } else {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                111);
                    }
                } else {

                    NavigateToPlayer();
                }
            }
        });

        my_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DownloadModel downloadModel = new DownloadModel();
                downloadModel.setEmail("bb@gmail.com");
                downloadModel.setUserId("151404");
                downloadModel.setRestrictionStatus(true);

                Intent mydownload = new Intent(MainActivity.this, MyDownloads.class);
                mydownload.putExtra("DownloadModel",downloadModel);
                startActivity(mydownload);
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

    public void NavigateToPlayer() {
        if (Video_Name.contains("-----Select Video----")) {
            Toast.makeText(getApplicationContext(), "Please Select A Video.", Toast.LENGTH_LONG).show();
            return;
        }

        if(ip.isChecked())
            playerModel.useIp(true);
        else
            playerModel.useIp(false);

        if(email.isChecked())
            playerModel.useEmail(true);
        else
            playerModel.useEmail(false);

        if(date.isChecked())
            playerModel.useDate(true);
        else
            playerModel.useDate(false);



        Intent playerIntent = new Intent(MainActivity.this, ExoPlayerActivity.class);
        playerIntent.putExtra("PlayerModel", playerModel);
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
