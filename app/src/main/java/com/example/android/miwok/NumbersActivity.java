package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //ArrayList to store words
        ArrayList<String> words = new ArrayList<String>();
       //Create an array of numbers in English
        String[] wordsEnglish =
                new String[]{"One", "Two","Three","Four","Five","Siz","Seven","Eight","Nine","Ten"};
        int k = 0;
        while(k < wordsEnglish.length )
        {
            words.add(wordsEnglish[k]);
            k++;
        }




        //Create an array of numbers in Miwok
        String[] wordsMiwok =
                new String[]{"lutti", "ottiko", "tolookosu", "oyyisa", "massoka", "temmokka", "kenekaku", "kawinta", "wo'e", "na'aacha"};
        k= 0;

        while(k < wordsEnglish.length){
            Log.v("NumberActivity.java", "WordsEnglish at index "+k +": " + words.get(k));
            Log.v("NumberActivity.java", "WordsMiwok at index " +k +": " + wordsMiwok[k]);
            k++;
        }

    }



}
