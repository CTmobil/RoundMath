package com.belnek.roundmath;

 import android.app.Service;
 import android.content.Intent;
 import android.media.MediaPlayer;
 import android.os.IBinder;
 import  android.util.Log;
 import android.widget.Toast;
public class BGMusic extends Service {
    private static final String TAG = "MyService";
    public static boolean MusicIsPlayed = true;
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.bgmusic);
        player.setLooping(true); // зацикливаем
    }

    @Override
    public void onDestroy() {
        player.stop();
    }

    @Override
    public void onStart(Intent intent, int startid) {
        player.start();
    }
}

