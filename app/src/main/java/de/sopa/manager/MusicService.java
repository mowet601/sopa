package de.sopa.manager;

import android.media.MediaPlayer;
import java.io.IOException;

/**
 * David Schilling - davejs92@gmail.com
 */
public class MusicService {

    private MediaPlayer mediaPlayer;
    private boolean prepared;

    public MusicService(MediaPlayer mediaPlayer, boolean prepared) {
        this.mediaPlayer = mediaPlayer;
        this.prepared = prepared;
    }

    public void playMusic() {
        if(!mediaPlayer.isPlaying()){
            if(!prepared){
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                prepared = true;
            }
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    public void stopMusic() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            prepared = false;
        }
    }
}