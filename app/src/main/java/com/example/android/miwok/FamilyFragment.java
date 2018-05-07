package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_REQUEST_GRANTED;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

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

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //ArrayList to store words
        final ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"father", "mother","son","daughter","older brother","younger brother","older sister","younger sister","grandmother","grandfather"};
        String[] wordsMiwok =
                new String[]{"әpә", "әṭa", "angsi", "tune", "taachi", "chalitti", "teṭe", "kolliti", "ama", "paapa"};
        int[] imageSourceID =
                new int[]{R.drawable.family_father, R.drawable.family_mother, R.drawable.family_son, R.drawable.family_daughter, R.drawable.family_older_brother, R.drawable.family_younger_brother, R.drawable.family_older_sister, R.drawable.family_younger_sister
                        ,R.drawable.family_grandmother, R.drawable.family_grandfather};
        int[] mediaSourceID =
                new int[]{R.raw.family_father, R.raw.family_mother, R.raw.family_son, R.raw.family_daughter, R.raw.family_older_brother, R.raw.family_younger_brother, R.raw.family_older_sister, R.raw.family_younger_sister
                        ,R.raw.family_grandmother, R.raw.family_grandfather};

        //Set a BackGroundColor for the TextView Layout
        int textViewBackGroundColor = R.color.category_family;

        int index = 0;
        while(index < wordsEnglish.length)
        {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], imageSourceID[index], mediaSourceID[index]));
            index++;
        }
        WordAdapter itemsAdapter = new WordAdapter (getActivity(), words, textViewBackGroundColor);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                //Obtain/Request Audio Focus for Miwok App to play audio and react when Focus is changed.
                int resultOfRequestAudioFocus = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC , AUDIOFOCUS_GAIN_TRANSIENT);

                if(resultOfRequestAudioFocus == AUDIOFOCUS_REQUEST_GRANTED) {
                    //Release the audio file in case it wasn't removed at first place
                    releaseMediaPlayer();

                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getMediaSourceID());
                    mMediaPlayer.start();

                    //Release the audio file once audio file is completed
                    mMediaPlayer.setOnCompletionListener(mOnCompletedListener);
                }

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
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

            // Regardless of whether or not we were granted audio focus, abandon it. getActivity() also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    };
}
