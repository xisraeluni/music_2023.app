package com.example.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play_paused;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_paused = (Button) findViewById(R.id.play_pause);
        mp = MediaPlayer.create(this, R.raw.izalco);
        play_paused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()){
                    mp.pause();
                    play_paused.setBackgroundResource(R.drawable.play_button);
                    Toast.makeText(MainActivity.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp.start();
                    play_paused.setBackgroundResource(R.drawable.pause_button);
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}