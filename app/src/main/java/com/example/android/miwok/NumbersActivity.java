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
                new String[]{"One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        int index = 0;
        while(index < wordsEnglish.length )
        {
            words.add(wordsEnglish[index]);
            index++;
        }
        //Create Parent LinearLayout View
        LinearLayout numberLinearLayout_View = (LinearLayout)findViewById(R.id.rootView);

        //Create ArrayList of TextViews and setText for each TextViews before add to parentView.
        ArrayList<TextView> numberTextViewList = new ArrayList<TextView>();
        index = 0;
        while(index < words.size()){
            numberTextViewList.add(new TextView(this));
            numberTextViewList.get(index).setText(words.get(index));
            numberLinearLayout_View.addView(numberTextViewList.get(index));
            index++;
        }

        //Create Parent LinearLayout View
        LinearLayout parentView_Miwok= (LinearLayout)findViewById(R.id.miwokView);
        //Create an array of numbers in Miwok
        String[] wordsMiwok =
                new String[]{"lutti", "ottiko", "tolookosu", "oyyisa", "massoka", "temmokka", "kenekaku", "kawinta", "wo'e", "na'aacha"};
        ArrayList<TextView> miwokNumberTextViewList = new ArrayList<TextView>();

        for(index = 0; index <wordsMiwok.length; index++){
            miwokNumberTextViewList.add(new TextView(this));
            miwokNumberTextViewList.get(index).setText(wordsMiwok[index]);
            parentView_Miwok.addView(miwokNumberTextViewList.get(index));
            Log.v("NumbersActivity.java", "TextView setText value of index" + wordsMiwok[index]);
        }


        /*//Create an array of numbers in Miwok
        String[] wordsMiwok =
                new String[]{"lutti", "ottiko", "tolookosu", "oyyisa", "massoka", "temmokka", "kenekaku", "kawinta", "wo'e", "na'aacha"};

        TextView numberTextView = new TextView(this);
        numberTextView.setText(words.get(0));

        TextView numberTextViewTwo = new TextView(this);
        numberTextViewTwo.setText(words.get(1));
        //Add TextView as a child view to parents view, numberLinearLayout
        numberLinearLayout_View.addView(numberTextViewTwo);

*/





    }



}
