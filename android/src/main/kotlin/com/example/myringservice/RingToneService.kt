package com.example.myringservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings;
import android.widget.Toast


class RingToneService() : Service() {
    var mediaPlayer: MediaPlayer? = null


    override fun onBind(p0: Intent?): IBinder? {
        return  null;
    }


    override fun onCreate() {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer!!.setLooping(true); // Set looping
        mediaPlayer!!.setVolume(100F, 100F);
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer!!.start();
        Toast.makeText(getApplicationContext(), "Playing Bohemian Rashpody in the Background",    Toast.LENGTH_SHORT).show();
        return startId;
    }

    override fun onDestroy() {
        Toast.makeText(this, "Ringtone playing Stopped", Toast.LENGTH_LONG).show()
        mediaPlayer!!.stop();
        mediaPlayer!!.release();
    }
}