package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    //MediaPlayer handle all the Phrases sound files
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store words
        final ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"Where are you going?", "What is your name?","My name is...","How are you feeling?","I'm feeling good.",
                        "Are you coming?","Yes,I'm coming","I'm coming","Let's go.","Come here."};
        String[] wordsMiwok =
                new String[]{"minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit",
                        "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"};
        int[] mediaSourceID = new int[]{ R.raw.phrase_where_are_you_going, R.raw.phrase_what_is_your_name, R.raw.phrase_my_name_is, R.raw.phrase_how_are_you_feeling,
                R.raw.phrase_im_feeling_good, R.raw.phrase_are_you_coming, R.raw.phrase_yes_im_coming, R.raw.phrase_im_coming,R.raw.phrase_lets_go, R.raw.phrase_come_here};


       //Set a Background Color
        int textViewBackGroundColor = R.color.category_phrases;

        int index = 0;
        while(index < wordsEnglish.length) {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], mediaSourceID[index]));
            index++;
        }

        WordAdapter itemsAdapter = new WordAdapter (this, words,textViewBackGroundColor);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Set OnItemClickListener to ListView to handle MediaPlayer to play sound
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getMediaSourceID());
                mMediaPlayer.start();
            }
        });
    }
}
