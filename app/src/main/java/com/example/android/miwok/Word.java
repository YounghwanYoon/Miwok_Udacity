package com.example.android.miwok;

import javax.xml.transform.Source;

import static android.R.attr.data;

/**
 * Created by Ray on 7/22/2017.
 */
public class Word {

    private String mMiwokWord;
    private String mDefaultWord;
    private int mImageSourceID;
    private int mMediaSourceID;
    private final static int dataNotProvided=-1;

    /**
     *  Constructor takes both String variable of Miwok and Default language
     * @param miwokWord is the word in a language of Miwok
     * @param defaultWord is the word in a user's default language such as English
     */
    public Word(String miwokWord, String defaultWord){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
        mImageSourceID = dataNotProvided;
        mMediaSourceID = dataNotProvided;
    }

    /**
     *  Constructor takes both String variable of Miwok and Default language and MediaSound Source
     * @param miwokWord is the word in a language of Miwok
     * @param defaultWord is the word in a user's default language such as English
     */
    public Word(String miwokWord, String defaultWord, int MediaSourceID){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
        mImageSourceID = dataNotProvided;
        mMediaSourceID = MediaSourceID;
    }
    /**
     *  Constructor takes both String variable of Miwok and Default language
     * @param miwokWord is the word in a language of Miwok
     * @param defaultWord is the word in a user's default language such as English
     *@param imageSourceID is the drawable resource ID for hte image
     */
    public Word(String miwokWord, String defaultWord, int imageSourceID, int mediaSourceID){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
        mImageSourceID = imageSourceID;
        mMediaSourceID = mediaSourceID;
    }

    public String getMiwokTranslation(){
        return mMiwokWord;
    }

    public String getDefaultTranslation(){
        return mDefaultWord;
    }

    public int getImageSourceID(){return mImageSourceID;}

    public int getMediaSourceID() {
        return mMediaSourceID;
    }

    public boolean hasImage(){
        return mImageSourceID != dataNotProvided;
    }

}
