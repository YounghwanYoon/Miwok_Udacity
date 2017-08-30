package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store words
        ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"Where are you going?", "What is your name?","My name is...","How are you feeling?","I'm feeling good.","Are you coming?","Yes,I'm coming","I'm coming","Let's go.","Come here."};
        String[] wordsMiwok =
                new String[]{"minto wuksus", "tinnә oyaase'nә", "oyaaset...", "michәksәs?", "kuchi achit", "әәnәs'aa?", "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"};
        int textViewBackGroundColor = R.color.category_phrases;

        int index = 0;
        while(index < wordsEnglish.length) {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], textViewBackGroundColor));
            index++;
        }

        WordAdapter itemsAdapter = new WordAdapter (this, words);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
