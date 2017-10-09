package com.muvi.muviplayersdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.muvi.muviplayersdk.activity.ExoPlayerActivity;
import com.muvi.muviplayersdk.activity.Player;
import com.muvi.muviplayersdk.utils.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Player playerModel;
    ArrayList<String> subtitleName;
    ArrayList<String> resolutionFormate;
    ArrayList<String> fakeSubtitlePtah;
    ArrayList<String> subtitlepath;
    ArrayList<String> resolutionUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerModel=new Player();
        subtitleName=new ArrayList<String>();//Creating arraylist
        subtitlepath=new ArrayList<String>();//Creating arraylist
        subtitleName.add("Burmese");//Adding object in arraylist
        subtitleName.add("English");
        resolutionFormate=new ArrayList<String>();
        resolutionFormate.add("BEST");//Adding object in arraylist
        resolutionFormate.add("720p");
        resolutionFormate.add("360p");
        resolutionFormate.add("144p");
        fakeSubtitlePtah=new ArrayList<String>();//Creating arraylist
        fakeSubtitlePtah.add("https://d25urtqf5dbnwr.cloudfront.net/subtitle/2779/CulturalFlavoursItaly-Burmese.vtt?Expires=1501738482&Signature=B9jT-aUsvY~PJploOTIupjRROi0ffu7e30BM6-vWtuOekvCmy1JQ0FDfqU~vQ5RGSNqOQOEzpFtPgZgcoMpiKpfPj4UX9xAEsmknVDM9XMKieSZGSaLtl3LpUP0Hq4mrSoSne9cnWGfITfGAkiXYVae9eCFx6CHSydRPVAiToJ94aBYcWCj5Of3JMhsFOHL7YtmZntMYhmmlJVylWg-OWJmoLoZRLxOBjgzygW8ow6J0dl1~H29UAhkaTqwWNg-ZkZyHJmNtA~OG0g8pv2JPBTP6P~8JD3OakkkrsWuvxJf1IaKMkWbDqrQsBbMx7efM7yEW-gsOLh2k6uqII8a9Pw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/subtitle/2780/CulturalFlavoursItaly-English.vtt?Expires=1501738482&Signature=fHFITxI76mrZ4x3e5gWh~dvQX~XDmOBFNVVf8ZwZfXjmwl3bGCLaJhiNzpxXd56~Lr1VanWRehW6ZIQRAToFqgp3vExuTYgKsg7h04EnjRdok3DQhmYIKMsitJSNgw7MpT9ztl0TgP4R7~j6XrGCWf4WQGtZKOf1B5rBTVc7VTystKKjWQHFBsm~rac-NcH6EEmxGGjC7WTr5wa8yF9amBYwAE9VSV6W6cZ7qIUiBX3N-nltidLw9ip6LWowwnMmASscNkS9GkCR5nGw8rYcHiMGLfWrBl-qyjKxtc4bTk1o1dPgbIdzAc6J2lxAKNFmfIIWVZUoGKRt0iu03nih7A__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");//Adding object in arraylist
        resolutionUrl=new ArrayList<String>();//Creating arraylist
        resolutionUrl.add("https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy.mp4?Expires=1501740214&Signature=jWoASSa8M~1rVAvxXkI~uIQJuSADwQLqihSj9uVs7v15uDB25h11s0OBTr4sxpdsOwJLPDmy1wZMZ7raREoYGrFltENqq9BZiZNGYKV9rei9IAEVj8fO~AMHKBQZqLLiWTKhjlOLwL06k4B5dyAOCqOGQgXSlBDYGJBz50yQJz50q9Wj4U-Rmx6pDYqOZeVhTOVa4Fot4XLc~tAhPCz5eWmo-xPHkOgF84pWDC-juKATDsu3yyE3rnOlJEVFxCD6h0AP79cfEFFMAueYr~4x9SE1m9MAArq~27wPp5oCoR9ypd-7Cg~WNswAaqUD~7rlM3hLU2IzII-fIBmJd1Ipyw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_1210.mp4?Expires=1501740214&Signature=FzyWOeiuIfjQcL0sa8goBcP9y~uEkU0B2O4JmUx38kZxn9fJqbJL5gAlhQemN3flyU9kzYC2XwGYMFJouf2vcEkhONnaQqF8tjPH~waRuI1Rjv0enXjSeoBXPqLwdz9L-xPkdvxPQhkYZU9iWZLmZFdX3KP6jB8MRlYKxP6~E-6YoiuTbVOq4EBwAualA0VaVqPiIf1vGr4MQGbFLDHkhvo3PBbvmIl46wFa84yzp7Cg0Gjkq000Upwh31~QJdmUwCuD56dQ~5dU3mPIEsRqkjo2rQUXu0oLGu5rLo2a~ymeGmwG7YJVMGON9XwG5D5SaBZCBvqlRVFrPWWA6fuNQg__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_317.mp4?Expires=1501740214&Signature=PfYVBHE7VdSSzHe9j6OWwrOlRfni-qKozsPDnXlo9REtJeCuoDeYeOM3hABceKz-KDA0cEdYmScyHpFSGXX9Oryh01J1hn21M330DscH4xdaES4TIYqw5dhvQ2M3M0iG09QEF4wZnzQWCkE3ABXHOGNAiM8gvIJib10naIEKRJ5u70OcaexKDzVAUNI9t0ZNggWZg01EHMzxwrBVxRp3hFsmPwb8NEs8dEXRDFJ2y7CxLqh18mMfgdnon2QJJUmJjeH72LI~ARjRl-aNCxzDQfykiVEkQyRs94EVXbWJIpvs8N~v6s5LUS-xwbu0BkFJumAalEnJNPpRUYTVvQMFOQ__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_108.mp4?Expires=1501740214&Signature=hrxWj6OAqVtT4p0xUTyHaC4yNgHsgPxOHEZMjZYyh9bgla1n4H3fqqoTfD8Q~w0i1pJqo8pizo21M5I4NIvnEau9rnGJY3w~mH5mkFFMarQe1FOOy7qwFapKMEwiOOrXmNJJFk8EKhMarQRr5dFVyAGEDKksn4ZBCvjVFBm4hYjwC18ERedtwF1o3nZNZbyeVXHaXtrY7JLpGBFa~ul57JLNk7bZdn0tjaVdwjFcytGyxmwcD50oOejKsBceqgWUf1CgSVY2vvoMBWNtz5Yfkdy-zuxNCITnviJqyT1h2uxA~AYyb~g2BbJaP-3WiMMtN9bUcaL4XkNFEiuz4b8VzA__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");

       // playerModel.setVideoUrl("https://www.youtube.com/watch?v=DmjBXJrPu18");
        //playerModel.setVideoUrl("https://player.vimeo.com/video/192417650?color=00ff00&badge=0");
        //playerModel.setThirdPartyPlayer(true);


         playerModel.setVideoUrl("ms3://ms3.test.expressplay.com:8443/hms/ms3/rights/?b=ABMABAADERwACURSTTQtTXV2aWl2ABAe2Dh-9TM6dhJAmG5sx6PzAIA2d943WTbc8mk6roj0y7BniqrgszpHL7FZAXdL8uHRAvYZwFwWy7NsSiAEz9xF5MS34RHloYcZmZWawmx58fB-CwO1oEySMKDMZUb-i3T061UfO6wEG3YgxaLJtmsBFKmC9VSGGz-IWi_W3bRUpefuK_LrpUPYlaBhpumnHTt5gQAAABRsWf9ZadhLZhUJMLYky_sT-JNaSg#https%3A%2F%2Fvimeoassets-singapore.s3-ap-southeast-1.amazonaws.com%2F4050%2FEncodedVideo%2Fuploads%2Fmovie_stream%2Ffull_movie%2F91003%2Fstream.mpd");
       //playerModel.setVideoUrl("https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_1210.mp4?Expires=1501740214&Signature=FzyWOeiuIfjQcL0sa8goBcP9y~uEkU0B2O4JmUx38kZxn9fJqbJL5gAlhQemN3flyU9kzYC2XwGYMFJouf2vcEkhONnaQqF8tjPH~waRuI1Rjv0enXjSeoBXPqLwdz9L-xPkdvxPQhkYZU9iWZLmZFdX3KP6jB8MRlYKxP6~E-6YoiuTbVOq4EBwAualA0VaVqPiIf1vGr4MQGbFLDHkhvo3PBbvmIl46wFa84yzp7Cg0Gjkq000Upwh31~QJdmUwCuD56dQ~5dU3mPIEsRqkjo2rQUXu0oLGu5rLo2a~ymeGmwG7YJVMGON9XwG5D5SaBZCBvqlRVFrPWWA6fuNQg__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA");
        // playerModel.setVideoUrl("https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/80989/Kyo_Kar_242.mp4?Expires=1501716785&Signature=UsKY7fL3b6cCCZz4mcPs22r2qH~3mDRiHewodoGNY5lshRkHyIcY6wT6E4UewC9L44TXSzEVWd5dl1r0r5IOqDW39vjbs-yR67CoDf~cKnvUoGtvsEwrxKrSsdcpogWb7AkjErhlKU~xZx0-Axhdz77dZaQto4hIZ40ZJn8HPyF25Oc7mahRwRBNAO4A-jaz4AV2eFKya79rHopRCTXf~FDEJ~UIVDQw3S52U0q9ZB-4Z7IhETu4FnJjO-eqn70mU3AoikCKuonUb0r1MihJRm5LrNzafXluCe8hL8pJ7XZgrAAZOqFpVYoIHmANuNwvc7G0xbgasX88Ewnck7sfuw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA\n");
        playerModel.setStreamUniqueId("cd222bdc2af51646483a4ae9271074b6");
        playerModel.setMovieUniqueId("b3acd62aaa10103ae0e9cea9f031ac54");
        playerModel.setUserId("151404");
        playerModel.setEmailId("bb@gmail.com");
        playerModel.setAuthTokenStr("25e74a5c88d19c4b57c8138bf47abdf7");
        playerModel.setRootUrl(Util.rootUrl().trim());
        playerModel.setAppName(getResources().getString(com.example.muviplayersdk.R.string.app_name));

       // If the contnet is a single part
        playerModel.setEpisode_id("0");
        // If the contnet is a multi part
        playerModel.setEpisode_id("cd222bdc2af51646483a4ae9271074b6"); // set stream unique id as episode id

        playerModel.setVideoTitle("Humanima - Gorillas And Men");
        playerModel.setVideoStory("This series explores the world of men and women who have forged a unique bond with wildlife and nature. They have dedicated their lives to their passion. They care deeply about the protection of the environment and share a common desire for the preservation of animal life. They make us realize that we can respect and share our world with other species.\n");
        playerModel.setVideoGenre("DOCUMENTARY , ENGLISH");
        playerModel.setVideoDuration("00:23:41");
        playerModel.setVideoReleaseDate("");
        playerModel.setCensorRating("");
        playerModel.setSubTitleName(subtitleName);
        playerModel.setSubTitlePath(subtitlepath);
        playerModel.setResolutionFormat(resolutionFormate);
        playerModel.setResolutionUrl(resolutionUrl);
        playerModel.setFakeSubTitlePath(fakeSubtitlePtah);
        playerModel.setVideoResolution("360");
       // playerModel.setIsFreeContent("0");
        https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy.mp4?Expires=1501740214&Signature=jWoASSa8M~1rVAvxXkI~uIQJuSADwQLqihSj9uVs7v15uDB25h11s0OBTr4sxpdsOwJLPDmy1wZMZ7raREoYGrFltENqq9BZiZNGYKV9rei9IAEVj8fO~AMHKBQZqLLiWTKhjlOLwL06k4B5dyAOCqOGQgXSlBDYGJBz50yQJz50q9Wj4U-Rmx6pDYqOZeVhTOVa4Fot4XLc~tAhPCz5eWmo-xPHkOgF84pWDC-juKATDsu3yyE3rnOlJEVFxCD6h0AP79cfEFFMAueYr~4x9SE1m9MAArq~27wPp5oCoR9ypd-7Cg~WNswAaqUD~7rlM3hLU2IzII-fIBmJd1Ipyw__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_1210.mp4?Expires=1501740214&Signature=FzyWOeiuIfjQcL0sa8goBcP9y~uEkU0B2O4JmUx38kZxn9fJqbJL5gAlhQemN3flyU9kzYC2XwGYMFJouf2vcEkhONnaQqF8tjPH~waRuI1Rjv0enXjSeoBXPqLwdz9L-xPkdvxPQhkYZU9iWZLmZFdX3KP6jB8MRlYKxP6~E-6YoiuTbVOq4EBwAualA0VaVqPiIf1vGr4MQGbFLDHkhvo3PBbvmIl46wFa84yzp7Cg0Gjkq000Upwh31~QJdmUwCuD56dQ~5dU3mPIEsRqkjo2rQUXu0oLGu5rLo2a~ymeGmwG7YJVMGON9XwG5D5SaBZCBvqlRVFrPWWA6fuNQg__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_317.mp4?Expires=1501740214&Signature=PfYVBHE7VdSSzHe9j6OWwrOlRfni-qKozsPDnXlo9REtJeCuoDeYeOM3hABceKz-KDA0cEdYmScyHpFSGXX9Oryh01J1hn21M330DscH4xdaES4TIYqw5dhvQ2M3M0iG09QEF4wZnzQWCkE3ABXHOGNAiM8gvIJib10naIEKRJ5u70OcaexKDzVAUNI9t0ZNggWZg01EHMzxwrBVxRp3hFsmPwb8NEs8dEXRDFJ2y7CxLqh18mMfgdnon2QJJUmJjeH72LI~ARjRl-aNCxzDQfykiVEkQyRs94EVXbWJIpvs8N~v6s5LUS-xwbu0BkFJumAalEnJNPpRUYTVvQMFOQ__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA, https://d25urtqf5dbnwr.cloudfront.net/uploads/movie_stream/full_movie/79421/Cultural_Flavours___Italy_108.mp4?Expires=1501740214&Signature=hrxWj6OAqVtT4p0xUTyHaC4yNgHsgPxOHEZMjZYyh9bgla1n4H3fqqoTfD8Q~w0i1pJqo8pizo21M5I4NIvnEau9rnGJY3w~mH5mkFFMarQe1FOOy7qwFapKMEwiOOrXmNJJFk8EKhMarQRr5dFVyAGEDKksn4ZBCvjVFBm4hYjwC18ERedtwF1o3nZNZbyeVXHaXtrY7JLpGBFa~ul57JLNk7bZdn0tjaVdwjFcytGyxmwcD50oOejKsBceqgWUf1CgSVY2vvoMBWNtz5Yfkdy-zuxNCITnviJqyT1h2uxA~AYyb~g2BbJaP-3WiMMtN9bUcaL4XkNFEiuz4b8VzA__&Key-Pair-Id=APKAJYIDWFG3D6CNOYVA


        Log.v("BKS","stramid=="+playerModel.getStreamUniqueId());
        Log.v("BKS","movieID=="+playerModel.getMovieUniqueId());
        Log.v("BKS","userid=="+playerModel.getUserId());
        Log.v("BKS","emailid=="+playerModel.getEmailId());
        Log.v("BKS","freecontent=="+playerModel.getIsFreeContent());
        Log.v("BKS","videotitle=="+playerModel.getVideoTitle());
        Log.v("BKS","video story==="+playerModel.getVideoStory());
        Log.v("BKS","video genre=="+playerModel.getVideoGenre());
        Log.v("BKS","duration=="+playerModel.getVideoDuration());
        Log.v("BKS","release date=="+playerModel.getVideoReleaseDate());
        Log.v("BKS","sensor rating=="+playerModel.getCensorRating());

        Intent playerIntent=new Intent(MainActivity.this,ExoPlayerActivity.class);
        playerIntent.putExtra("PlayerModel",playerModel);
        startActivity(playerIntent);
    }
}
