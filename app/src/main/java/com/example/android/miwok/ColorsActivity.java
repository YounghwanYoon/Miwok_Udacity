package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_REQUEST_GRANTED;

public class ColorsActivity extends AppCompatActivity {

    //MediaPlayer handle all the Numbers sound files
    private MediaPlayer mMediaPlayer;

    //AudioManager handle request/abandon audio focus over other system
    private AudioManager mAudioManager;

    //MediaPlayer onCompletionListenr which release media source once the playing is completed.
    private MediaPlayer.OnCompletionListener mOnCompletedListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                // Pause playback because your Audio Focus was
                // temporarily stolen, but will be back soon.
                // i.e. for a phone call
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Stop playback, because you lost the Audio Focus.
                // i.e. the user started some other playback app
                // Remember to unregister your controls/buttons here.
                // And release the kra — Audio Focus!
                // You’re done.
                mMediaPlayer.release();
                mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            } else if (focusChange ==
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Lower the volume, because something else is also
                // playing audio over you.
                // i.e. for notifications or navigation directions
                // Depending on your audio playback, you may prefer to
                // pause playback here instead. You do you.

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback, because you hold the Audio Focus
                // again!
                // i.e. the phone call ended or the nav directions
                // are finished
                // If you implement ducking and lower the volume, be
                // sure to return it to normal here, as well.
                mMediaPlayer.start();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Log.e("ColorsActivitiy","I am inside onCreate method");

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //ArrayList to store words
        final ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English
        String[] wordsEnglish =
                new String[]{"red", "green","brown","gray","black","white","dusty yellow","mustard yellow"};
        //Create an array of numbers in Miwok
        String[] wordsMiwok =
                new String[]{"weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә", "chiwiiṭә"};
        int[] imageSourceID =
                new int[]{R.drawable.color_red, R.drawable.color_green, R.drawable.color_brown, R.drawable.color_gray, R.drawable.color_black, R.drawable.color_white, R.drawable.color_dusty_yellow, R.drawable.color_mustard_yellow};
        int[] mediaSourceID = new int[]{R.raw.color_red, R.raw.color_green, R.raw.color_brown, R.raw.color_gray, R.raw.color_black, R.raw.color_white, R.raw.color_dusty_yellow, R.raw.color_mustard_yellow};
        //Set Background color for ColorsActivity
        int textViewBackGroundColor = R.color.category_colors;

        int index = 0;
        while(index < wordsEnglish.length)
        {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], imageSourceID[index], mediaSourceID[index]));
            index++;
        }

        WordAdapter itemsAdapter = new WordAdapter (this, words, textViewBackGroundColor);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);
                Log.e("ColorsActivitiy","I am inside listView Set OnclickListener");
                //Obtain/Request Audio Focus for Miwok App to play audio and react when Focus is changed.
                int resultOfRequestAudioFocus = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC , AUDIOFOCUS_GAIN_TRANSIENT);

                if(resultOfRequestAudioFocus == AUDIOFOCUS_REQUEST_GRANTED) {
                    //Release the audio file in case it wasn't removed at first place
                    releaseMediaPlayer();

                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMediaSourceID());
                    mMediaPlayer.start();

                    //Release the audio file once audio file is completed
                    mMediaPlayer.setOnCompletionListener(mOnCompletedListener);
                }

            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();

        //When activity is stopped while playing an audio file, the app will release audiofile form MediaPlayer Class on onStop Status.
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    };
}
