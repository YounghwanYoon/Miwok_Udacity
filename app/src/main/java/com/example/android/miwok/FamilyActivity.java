package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    //MediaPlayer handle all the Family sound files
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getMediaSourceID());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
}
