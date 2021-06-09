package com.raj_shah.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ImageButton btnbackward,btnplay,btnpause,btnforward;
    TextView tvstarttime,tvsongtime;
    SeekBar seekbar;
    MediaPlayer mediaPlayer;
    static int otime=0, stime=0, etime=0, ftime=5000, btime=5000;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbackward=findViewById(R.id.btnbackward);
        btnplay=findViewById(R.id.btnplay);
        btnpause=findViewById(R.id.btnpause);
        btnforward=findViewById(R.id.btnforward);

        tvstarttime=findViewById(R.id.tvstarttime);
        tvsongtime=findViewById(R.id.tvsongtime);

        seekbar=findViewById(R.id.seekbar);

        btnpause.setEnabled(false);
        seekbar.setClickable(false);

        mediaPlayer=MediaPlayer.create(this,R.raw.mysong);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing Audio", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                stime=mediaPlayer.getCurrentPosition();
                etime=mediaPlayer.getDuration();

                if (otime==0){
                    seekbar.setMax(etime);
                    otime=1;
                }

                tvstarttime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(stime), TimeUnit.MILLISECONDS.toSeconds(stime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(stime))));

                tvsongtime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(etime), TimeUnit.MILLISECONDS.toSeconds(etime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(etime))));

                seekbar.setProgress(stime);

                handler.postDelayed(UpdateSongTime,100);

                btnpause.setEnabled(true);
                btnplay.setEnabled(false);
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

                btnpause.setEnabled(false);
                btnplay.setEnabled(true);

                Toast.makeText(MainActivity.this, "Audio Paused", Toast.LENGTH_SHORT).show();
            }
        });

        btnforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((stime+ftime)<=etime){
                    stime=stime+ftime;

                    mediaPlayer.seekTo(stime);
                }
                else {
                    Toast.makeText(MainActivity.this, "Cannot Jump Forward for 5 Seconds", Toast.LENGTH_SHORT).show();
                }

                if (btnplay.isEnabled()){
                    btnplay.setEnabled(true);
                }
            }
        });

        btnbackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((stime-btime)>0){
                    stime=stime-btime;

                    mediaPlayer.seekTo(stime);
                }
                else {
                    Toast.makeText(MainActivity.this, "Cannot Jump Backward for 5 Seconds", Toast.LENGTH_SHORT).show();
                }

                if (btnplay.isEnabled()){
                    btnplay.setEnabled(true);
                }
            }
        });
    }

    private Runnable UpdateSongTime=new Runnable() {
        @Override
        public void run() {
            stime=mediaPlayer.getCurrentPosition();

            tvstarttime.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(stime), TimeUnit.MILLISECONDS.toSeconds(stime)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(stime))));

            seekbar.setProgress(stime);

            handler.postDelayed(this,100);
        }
    };
}