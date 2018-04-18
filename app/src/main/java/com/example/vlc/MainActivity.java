package com.example.vlc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;

import org.videolan.libvlc.IVLCVout;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LibVLC libVLC=null;
    private SurfaceView surfaceView=null;
    private MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView= (SurfaceView) findViewById(R.id.surfaceView);
        ArrayList<String> options=new ArrayList<>();
        options.add("-vvv");
        libVLC=new LibVLC(this,options);
        mediaPlayer=new MediaPlayer(libVLC);
        IVLCVout ivlcVout=mediaPlayer.getVLCVout();
        ivlcVout.setVideoView(surfaceView);
        ivlcVout.attachViews();
        Media media=new Media(libVLC, Uri.parse("rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov") );
        mediaPlayer.setMedia(media);
        mediaPlayer.play();
    }

}
