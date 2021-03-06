/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        Log.v("MainActivity.java", "I'm onCreate State");


// Second way to make a clickable: Local Method within TextView's setOnclickListener Method

        //Find the View that shows the numbers category
        final TextView numberView = (TextView) findViewById(R.id.numbers);

        //Set a clickListener on that view
        numberView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new intent to open the {@Link NumberActivity)
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        //Find the View that shows the Colors category
        final TextView ColorsActivity = (TextView) findViewById(R.id.colors);

        //Set a clickListener on that view
        ColorsActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Create a new intent to open the (@Link ColorsActivity)
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                //Start the new activity
                startActivity(colorsIntent);
            }
        });

        //Find the View that shows the Family category
        final TextView familyActivity = (TextView) findViewById(R.id.family);

        //Set a clickListener on that view
        familyActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Create a new intent to open the (@Link FamilyActivity)
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                //Start the new activity
                startActivity(familyIntent);
            }
        });

        //Find the View that shows the Phrases category
        final TextView phrasesActivityTextView = (TextView) findViewById(R.id.phrases);

        //Set a clickListener on that view
        phrasesActivityTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Create a new intent to open the (@Link PhrasesActivity)
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                //Start the new activity
                startActivity(phrasesIntent);
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity.java", "I'm on Pause State");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("FamilyActivity.java", "I'm on Resume State");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("FamilyActivity.java", "I'm on onStop State");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("FamilyActivity.java", "I'm on DestroyState");
    }

}

