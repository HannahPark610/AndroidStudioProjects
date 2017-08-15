package com.example.hyunyoungpark.mybroadcastreceiverdemo;


// Update Music Player App Created In Class
// •	Change button images to nine patch images.
// •	Can you modify the source code so that it can play any audio files on the SD card of the device? (optional)
// An Audio Player Running In The Background
// •	In practice, users often expect the audio player to keep on playing even if the main layout is minimized. This can be implemented by running a background service on the device.
// •	Modify the source code. We do not need extra data files or strings. When clicking on the buttons, the main thread of application will not do any real operation; instead, it will pass intents to the background service to trigger related actions.
// •	Use Service for background music paly

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Create an object for Media Player
    MediaPlayer player;
    ImageButton playButton, stopButton, resetButton;
    boolean play_reset = true;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate an object of media player
        
        player = MediaPlayer.create(this,  R.raw.shapeofyou);

        playButton = (ImageButton) this.findViewById(R.id.play);
        stopButton = (ImageButton) this.findViewById(R.id.stop);
        resetButton = (ImageButton) this.findViewById(R.id.reset);
        seekbar = (SeekBar)findViewById(R.id.seekBar);

        playButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
// If the user presses the buttonplay/pause button
// if no player instance is available, then create a media player first
                if (play_reset) {
                    play_reset = false;
                    player.setLooping(false); // Set looping
                }
                playPause();
                break;
            case R.id.stop:
                if (!play_reset) {
// If the user presses the stop button
                    player.stop();
// change the image of the buttonplay button to buttonplay
                    playButton.setImageResource(R.drawable.buttonplay);
                    Toast.makeText(this, R.string.stopped, Toast.LENGTH_SHORT).show();
                    try {
                        player.prepare();
                    } catch (IllegalStateException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.reset:
                if (!play_reset) {
// If the user presses the reset button
                    player.reset();
// change the image of the buttonplay button to buttonplay
                    playButton.setImageResource(R.drawable.buttonplay);
                    Toast.makeText(this, R.string.reset, Toast.LENGTH_SHORT).show();
// Release media instance to system
                    player.release();
                    play_reset = true;
                    break;
                }
        }
    }
    // when the activity is paused, then pause the music playback
    @Override
    public void onPause() {
        super.onPause();
        player.reset();
// change the image of the play button to play
        playButton.setImageResource(R.drawable.play);
        Toast.makeText(this, R.string.reset, Toast.LENGTH_SHORT).show();
// Release media instance to system
        player.release();
        play_reset = true;
    }
    // Toggle between the buttonplay and pause
    private void playPause() {
// if the music is playing then pause the music playback
        if(player.isPlaying()) {
            player.pause();
// change the image of the play button to play
            playButton.setImageResource(R.drawable.buttonplay);
            Toast.makeText(this, R.string.paused, Toast.LENGTH_SHORT).show();
        }
// Music is paused, start, or resume playback
        else {
// change the image of the play button to pause
            playButton.setImageResource(R.drawable.pause);
            player.start();
            Toast.makeText(this, R.string.isPlaying, Toast.LENGTH_SHORT).show();
        }
    }
}