package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 7/22/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    WordAdapter(Context context, ArrayList<Word> object)
    {
        super(context, 0, object );
    }


    public View getView(int position, ListView convertView, ViewGroup parent){
        View listItemView = convertView;

        //CHeck if the existing view is being reused, otherwise inflate the view
        if(listItemView == null ){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the object located at this position (Current Position) in the list
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        englishTextView.setText((currentWord.getDefaultTranslation()));

        return listItemView;
    }
}
