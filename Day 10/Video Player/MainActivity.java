package com.raj_shah.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoview=findViewById(R.id.videoview);

        MediaController mediaController=new MediaController(this);

        mediaController.setAnchorView(videoview);

        Uri uri=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.myvideo);

        videoview.setMediaController(mediaController);

        videoview.setVideoURI(uri);

        videoview.requestFocus();
        videoview.start();

        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Thank You...", Toast.LENGTH_SHORT).show();
            }
        });

        videoview.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}