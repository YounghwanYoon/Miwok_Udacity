package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store words
        ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"father", "mother","son","daughter","older brother","younger brother","older sister","younger sister","grandmother","grandfather"};
        String[] wordsMiwok =
                new String[]{"әpә", "әṭa", "angsi", "tune", "taachi", "chalitti", "teṭe", "kolliti", "ama", "paapa"};
        int[] imageSourceID =
                new int[]{R.drawable.family_father, R.drawable.family_mother, R.drawable.family_son, R.drawable.family_daughter, R.drawable.family_older_brother, R.drawable.family_younger_brother, R.drawable.family_older_sister, R.drawable.family_younger_sister
                        ,R.drawable.family_grandmother, R.drawable.family_grandfather};
        int textViewBackGroundColor = R.color.category_family;
        int index = 0;
        while(index < wordsEnglish.length)
        {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], imageSourceID[index], textViewBackGroundColor));
            index++;
        }
        WordAdapter itemsAdapter = new WordAdapter (this, words);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
