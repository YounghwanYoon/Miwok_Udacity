package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList to store words
        ArrayList<Word> words = new ArrayList<Word>();

        //Create an array of numbers in English and Miwok
        String[] wordsEnglish =
                new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] wordsMiwok =
                new String[]{"lutti", "ottiko", "tolookosu", "oyyisa", "massoka", "temmokka", "kenekaku", "kawinta", "wo'e", "na'aacha"};
        int[] imageSourceID =
                new int[]{R.drawable.number_one, R.drawable.number_two, R.drawable.number_three,R.drawable.number_four, R.drawable.number_five, R.drawable.number_six, R.drawable.number_seven, R.drawable.number_eight,
                R.drawable.number_nine, R.drawable.number_ten};

        int index = 0;
        while(index < wordsEnglish.length)
        {
            words.add(new Word(wordsEnglish[index], wordsMiwok[index], imageSourceID[index]));
            index++;
        }

        WordAdapter itemsAdapter = new WordAdapter (this, words);

        // Get a reference to the ListView, and attach the adapter to the listVew
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
