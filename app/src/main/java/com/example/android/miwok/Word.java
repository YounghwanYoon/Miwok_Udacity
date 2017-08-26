package com.example.android.miwok;

import javax.xml.transform.Source;

/**
 * Created by Ray on 7/22/2017.
 */
public class Word {

    private String mMiwokWord;
    private String mDefaultWord;
    private int  mImageSourceID;
    private final static int noImageID=-1;

    /**
     *  Constructor takes both String variable of Miwok and Default language
     * @param miwokWord is the word in a language of Miwok
     * @param defaultWord is the word in a user's default language such as English
     */
    public Word(String miwokWord, String defaultWord){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
        mImageSourceID = -1;
    }
    /**
     *  Constructor takes both String variable of Miwok and Default language
     * @param miwokWord is the word in a language of Miwok
     * @param defaultWord is the word in a user's default language such as English
     *@param imageSourceID is the drawable resource ID for hte image
     */
    public Word(String miwokWord, String defaultWord, int imageSourceID){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
        mImageSourceID = imageSourceID;
    }

    public void setMiwokWord(String miwokWord){
        mMiwokWord = miwokWord;
    }

    public void setDefaultWord(String defaultWord){
        mDefaultWord = defaultWord;
    }

    public void setmImageSourceID(int sourceImageID){mImageSourceID = sourceImageID;};

    public String getMiwokTranslation(){
        return mMiwokWord;
    }

    public String getDefaultTranslation(){
        return mDefaultWord;
    }

    public int getImageSourceID(){return mImageSourceID;};

    public boolean hasImage(){
        return mImageSourceID != noImageID;
    }
}
