package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store words
        ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"red", "green","brown","gray","black","white","dusty yellow","mustard yellow"};
        String[] wordsMiwok =
                new String[]{"weṭeṭṭi", "chokokki", "ṭakaakki", "ṭopoppi", "kululli", "kelelli", "ṭopiisә", "chiwiiṭә"};
        int[] imageSourceID =
                new int[]{R.drawable.color_red, R.drawable.color_green, R.drawable.color_brown, R.drawable.color_gray, R.drawable.color_black, R.drawable.color_white, R.drawable.color_dusty_yellow, R.drawable.color_mustard_yellow};
        int textViewBackGroundColor = R.color.category_colors;
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
