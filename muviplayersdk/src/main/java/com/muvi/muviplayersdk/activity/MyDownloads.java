package com.muvi.muviplayersdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.example.muviplayersdk.R;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.images.WebImage;
import com.muvi.muviplayersdk.adapter.MyDownloadAdapter;
import com.muvi.muviplayersdk.model.ContactModel1;
import com.muvi.muviplayersdk.model.DownloadModel;
import com.muvi.muviplayersdk.utils.DBHelper;
import com.muvi.muviplayersdk.utils.ProgressBarHandler;
import com.muvi.muviplayersdk.utils.Util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import static java.lang.Thread.sleep;


public class MyDownloads extends AppCompatActivity {


    String download_id_from_watch_access_table = "";
    //public static ProgressDialog  pDialog;
    Context context;
    ListView list;
    TextView noDataTextView;
    RelativeLayout nodata;
    MyDownloadAdapter adapter;
    String emailIdStr = "";
    DBHelper dbHelper;
    static String path,filename,_filename,token,title,poster,genre,duration,rdate,movieid,user,uniqid;
    ArrayList<ContactModel1> download;
    ProgressBarHandler pDialog;
    ArrayList<String> SubTitleName = new ArrayList<>();
    ArrayList<String> SubTitlePath = new ArrayList<>();

    ArrayList<String> Chromecast_Subtitle_Url = new ArrayList<String>();
    ArrayList<String> Chromecast_Subtitle_Language_Name = new ArrayList<String>();
    ArrayList<String> Chromecast_Subtitle_Code = new ArrayList<String>();


    int Played_Length = 0;
    String watch_status = "start";

    String PlayedLength = "0";
    String ipAddressStr = "";
    String MpdVideoUrl = "";
    String licenseUrl = "";
    String SubtitleUrl = "";
    String SubtitleLanguage = "";
    String SubtitleCode = "";

    /*chromecast-------------------------------------*/
    View view;

    private static final int MAX_LINES = 3;


    public enum PlaybackLocation {
        LOCAL,
        REMOTE
    }

    /**
     * List of various states that we can be in
     */
    public enum PlaybackState {
        PLAYING, PAUSED, BUFFERING, IDLE
    }

    private PlaybackLocation mLocation;
    private PlaybackState mPlaybackState;
    private final float mAspectRatio = 72f / 128;
    private AQuery mAquery;
    private MediaInfo mSelectedMedia;



    int corePoolSize = 60;
    int maximumPoolSize = 80;
    int keepAliveTime = 10;
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(maximumPoolSize);
    Executor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
    int Position = 0;
    public static ProgressBarHandler progressBarHandler;

    DownloadModel downloadModel  = new DownloadModel();


    MediaInfo mediaInfo;
    /*chromecast-------------------------------------*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydownload);
        dbHelper=new DBHelper(MyDownloads.this);
        dbHelper.getWritableDatabase();
        downloadModel = (DownloadModel) getIntent().getSerializableExtra("DownloadModel");



        registerReceiver(UpadateDownloadList, new IntentFilter("NewVodeoAvailable"));
        Toolbar mActionBarToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        mActionBarToolbar.setTitle(Util.getTextofLanguage(MyDownloads.this,Util.MY_DOWNLOAD,Util.DEFAULT_MY_DOWNLOAD));
        mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed();
                finish();
            }
        });

        if( getIntent().getExtras() == null)
        {
            //do here
            mActionBarToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        }

        list= (ListView)findViewById(R.id.listView);
        nodata= (RelativeLayout) findViewById(R.id.noData);
        noDataTextView= (TextView) findViewById(R.id.noDataTextView);


        emailIdStr = downloadModel.getEmail();

        download=dbHelper.getContactt(emailIdStr,1);
        if(download.size()>0) {
            adapter = new MyDownloadAdapter(MyDownloads.this , download);
            list.setAdapter(adapter);
        }else {
            nodata.setVisibility(View.VISIBLE);
            noDataTextView.setText(Util.getTextofLanguage(MyDownloads.this,Util.NO_CONTENT,Util.DEFAULT_NO_CONTENT));
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Position = position;
                SubtitleUrl = "";
                MoveToOfflinePlayer();

            }
        });
    }

    public void visible(){

        if(download.size()>0) {
            adapter = new MyDownloadAdapter(MyDownloads.this , download);
            list.setAdapter(adapter);

        }else {
            nodata.setVisibility(View.VISIBLE);
            noDataTextView.setText(Util.getTextofLanguage(MyDownloads.this,Util.NO_CONTENT,Util.DEFAULT_NO_CONTENT));
        }
    }

    public void ShowRestrictionMsg(String msg) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MyDownloads.this, R.style.MyAlertDialogStyle);

        dlgAlert.setMessage(msg);
        dlgAlert.setTitle(Util.getTextofLanguage(MyDownloads.this, Util.SORRY, Util.DEFAULT_SORRY));
        dlgAlert.setCancelable(false);
        dlgAlert.setPositiveButton(Util.getTextofLanguage(MyDownloads.this, Util.BUTTON_OK, Util.DEFAULT_BUTTON_OK),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        dlgAlert.create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(UpadateDownloadList);
    }


    private BroadcastReceiver UpadateDownloadList = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.v("BIBHU1","Onreceive called");

            download=dbHelper.getContactt(emailIdStr,1);
            if(download.size()>0) {
                adapter = new MyDownloadAdapter(MyDownloads.this,download);
                list.setAdapter(adapter);
                nodata.setVisibility(View.GONE);
            }
        }
    };


    public void MoveToOfflinePlayer() {
        SubTitleName.clear();
        SubTitlePath.clear();

        SQLiteDatabase DB = MyDownloads.this.openOrCreateDatabase(DBHelper.DATABASE_NAME, MODE_PRIVATE, null);
        Cursor cursor = DB.rawQuery("SELECT LANGUAGE,PATH FROM SUBTITLE_LUIMERE WHERE UID = '" + download.get(Position).getUniqueId() + "'", null);
        int count = cursor.getCount();

        if (count > 0) {
            if (cursor.moveToFirst()) {
                do {
                    SubTitleName.add(cursor.getString(0).trim());
                    SubTitlePath.add(cursor.getString(1).trim());


                    Log.v("BIBHU3", "SubTitleName============" + cursor.getString(0).trim());
                    Log.v("BIBHU3", "SubTitlePath============" + cursor.getString(1).trim());

                } while (cursor.moveToNext());
            }
        }


        if (downloadModel.getRestrictionStatus()){
            if (!CheckAccessPeriodOfDpwnloadContent()) {
                return;
            }
    }

        //This is applicable for resume watch feature on downloaed content

        Log.v("BIBHU3","===Database unique id at my download=="+download.get(Position).getUniqueId());

        Cursor cursor11 = DB.rawQuery("SELECT * FROM "+DBHelper.RESUME_WATCH+" WHERE UniqueId = '"+download.get(Position).getUniqueId()+"'", null);
        int count11 = cursor11.getCount();
        Log.v("BIBHU3","===Database unique id at my download=size="+count11);

        if (count11 > 0) {
            if (cursor11.moveToFirst()) {
                do {
                    PlayedLength = cursor11.getString(1).trim();
                    Log.v("BIBHU3","PlayedLength============"+PlayedLength);

                } while (cursor11.moveToNext());
            }
        }
        //==========================================END======================================//



        pDialog = new ProgressBarHandler(MyDownloads.this);
        pDialog.show();

        new Thread(new Runnable(){
            public void run(){

                final String pathh=download.get(Position).getPath();
                final String titles=download.get(Position).getMUVIID();
                final String gen=download.get(Position).getGenere();
                final String tok=download.get(Position).getToken();
                final String contentid=download.get(Position).getContentid();
                final String muviid=download.get(Position).getMuviid();
                final String poster=download.get(Position).getPoster();
                final String vidduration=download.get(Position).getDuration();
                final String filename=pathh.substring(pathh.lastIndexOf("/") + 1);


                try {
                    sleep(1200);

                    runOnUiThread(new Runnable() {
                        //
                        @Override
                        public void run() {

                            Intent in=new Intent(MyDownloads.this,MarlinBroadbandExample.class);
                            Log.v("SUBHA", "PATH" + pathh);


                            in.putExtra("SubTitleName", SubTitleName);
                            in.putExtra("SubTitlePath", SubTitlePath);

                            in.putExtra("FILE", pathh);
                            in.putExtra("Title", titles);
                            //in.putExtra("GENRE", gen);
                            in.putExtra("TOK", tok);
                            in.putExtra("poster", poster);
                            in.putExtra("contid", contentid);
                            in.putExtra("gen", gen);
                            in.putExtra("muvid", muviid);
                            in.putExtra("vid", vidduration);
                            in.putExtra("FNAME", filename);
                            in.putExtra("download_id_from_watch_access_table", download_id_from_watch_access_table);
                            in.putExtra("PlayedLength", PlayedLength);
                            in.putExtra("UniqueId",""+download.get(Position).getUniqueId());
                            in.putExtra("streamId",""+download.get(Position).getStreamId());
                            in.putExtra("download_content_type",""+download.get(Position).getDownloadContentType());



                            in.putExtra("Chromecast_Subtitle_Url",Chromecast_Subtitle_Url);
                            in.putExtra("Chromecast_Subtitle_Language_Name",Chromecast_Subtitle_Language_Name);
                            in.putExtra("Chromecast_Subtitle_Code",Chromecast_Subtitle_Code);



                            Log.v("BIBHU1","PlayedLength="+PlayedLength);

                            //
                            startActivity(in);
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {


                                    if (pDialog != null && pDialog.isShowing()) {
                                        pDialog.hide();
                                        pDialog = null;
                                    }
                                }
                            });
                        }
                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    public boolean CheckAccessPeriodOfDpwnloadContent()
    {

        // following block is responsible for restriction on download content .....

        SQLiteDatabase DB = MyDownloads.this.openOrCreateDatabase(DBHelper.DATABASE_NAME, MODE_PRIVATE, null);

        long server_current_time = 0;
        long watch_period = -1;
        long access_period = -1;
        long initial_played_time = 0;
        long updated_server_current_time = 0;

        Cursor cursor1 = DB.rawQuery("SELECT server_current_time , watch_period , access_period , initial_played_time , updated_server_current_time,download_id FROM "+DBHelper.WATCH_ACCESS_INFO+" WHERE download_id = '"+download.get(Position).getDOWNLOADID()+"'", null);
        int count1 = cursor1.getCount();

        if (count1 > 0) {
            if (cursor1.moveToFirst()) {
                do {
                    server_current_time = cursor1.getLong(0);
                    watch_period = cursor1.getLong(1);
                    access_period = cursor1.getLong(2);
                    initial_played_time = cursor1.getLong(3);
                    updated_server_current_time = cursor1.getLong(4);
                    download_id_from_watch_access_table = cursor1.getString(5);


                    Log.v("BIBHU3","server_current_time============"+server_current_time);
                    Log.v("BIBHU3","watch_period============"+watch_period);
                    Log.v("BIBHU3","access_period============"+access_period);
                    Log.v("BIBHU3","initial_played_time============"+initial_played_time);
                    Log.v("BIBHU3","updated_server_current_time============"+updated_server_current_time);
                    Log.v("BIBHU3","download_id_from_watch_access_table============"+download_id_from_watch_access_table);

                } while (cursor1.moveToNext());
            }
        }else
        {
            return false;
        }

        if(initial_played_time == 0)
        {
            if(((server_current_time < System.currentTimeMillis()) && (access_period > System.currentTimeMillis())) || (access_period == -1))
            {
                String Qry = "UPDATE " +DBHelper.WATCH_ACCESS_INFO+ " SET initial_played_time = '"+ System.currentTimeMillis()+"'" +
                        " WHERE download_id = '"+download.get(Position).getDOWNLOADID()+"' ";

                DB.execSQL(Qry);
                return true;
            }
            else
            {
                // Show Restriction Message
                ShowRestrictionMsg("You don't have access to play this video.");
                return false;

            }
        }
        else
        {
            if(updated_server_current_time < System.currentTimeMillis() || access_period == -1)
            {
                if(access_period == -1 || (System.currentTimeMillis() < access_period)) // && (((System.currentTimeMillis() - initial_played_time) < watch_period)) || watch_period == -1)
                {
                    String Qry = "UPDATE " +DBHelper.WATCH_ACCESS_INFO+ " SET updated_server_current_time = '"+ System.currentTimeMillis()+"'" +
                            " WHERE download_id = '"+download.get(Position).getDOWNLOADID()+"' ";
                    DB.execSQL(Qry);
                    return true;
                }
                else
                {
                    // Show Restriction Meassge
                    ShowRestrictionMsg("You don't have access to play this video.");
                    return false;
                }
            }
            else
            {
                // Show Restriction Message
                ShowRestrictionMsg("You don't have access to play this video.");
                return false;
            }
        }



        //=====================================END================================================//
    }

}



