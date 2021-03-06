package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 7/22/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

private int mBackGroundColor;
private MediaPlayer mediaPlayer;

    WordAdapter(Context context, ArrayList<Word> object, int backGroundColor)
    {
        super(context, 0, object);
        mBackGroundColor = backGroundColor;
        mediaPlayer = null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        //CHeck if the existing view is being reused, otherwise inflate the view
        if(listItemView == null ){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the object located at this position (Current Position) in the list
        final Word currentWord = getItem(position);
        Log.e("WordAdapter","I am inside WordAdapter class under View method");

        RelativeLayout currentRelativeLayout = (RelativeLayout) listItemView.findViewById(R.id.list_item);
        currentRelativeLayout.setBackgroundResource(mBackGroundColor);

        // Assign textView with current position miwok word.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Assign textView with current position default(English) word.
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        englishTextView.setText((currentWord.getDefaultTranslation()));

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage())
        {
            //Set Image with correct image source
            imageView.setImageResource(currentWord.getImageSourceID());
            //Show ImageView
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
