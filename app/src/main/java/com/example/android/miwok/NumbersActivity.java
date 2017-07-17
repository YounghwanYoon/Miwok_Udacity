package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

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
        //Create Parent LinearLayout View
        LinearLayout numberLinearLayout_View = (LinearLayout)findViewById(R.id.rootView);
        TextView numberTextView = new TextView(this);
        numberTextView.setText(words.get(0));

        TextView numberTextViewTwo = new TextView(this);
        numberTextViewTwo.setText(words.get(1));
        //Add TextView as a child view to parents view, numberLinearLayout
        numberLinearLayout_View.addView(numberTextViewTwo);


        ArrayList<TextView> numberTextViewList = new ArrayList<TextView>();
        int i = 0;
        while(i < 9){
            numberTextViewList.add(new TextView(this).setText(words.get(i)););

            numberLinearLayout_View.addView(numberTextViewList.get(i));
            i++
        }



    }



}
