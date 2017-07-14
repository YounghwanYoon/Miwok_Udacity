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

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numberView = (TextView) findViewById(R.id.family);
        numberView.setOnClickListener(numberListener);
    }

    /**
     * Once Number column is clicked, then NumbersActivity.class/ its screen will be opened.
     * @param view
     */
    public void openNumbersList(View view){
        //TODO: Write your code here!
        Intent numberIntent = new Intent(this, NumbersActivity.class);
        startActivity(numberIntent);
    }

    public void openColorsList(View view){
        //TODO: Write your code here!
        Intent colorIntent = new Intent(this, ColorsActivity.class);
        startActivity(colorIntent);
    }

    public void openFamilyList(View view){
        //TODO: Write your code here!
        Intent familyIntent = new Intent(this, FamilyActivity.class);
        startActivity(familyIntent);
    }

    private View.OnClickListener numberListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do something when the button is clicked
            openFamilyList(v);
        }
    };



}
