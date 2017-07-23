package com.example.android.miwok;

/**
 * Created by Ray on 7/22/2017.
 */
public class Word {

    private String mMiwokWord;
    private String mDefaultWord;

    //Constructor takes no variable
    public Word (){
        mMiwokWord = "unknown";
        mDefaultWord = "unknown";
    }
    //Constructor takes a String variable of Miwok
    public Word(String miwokWord){
        mMiwokWord = miwokWord;
        mDefaultWord = "unknown";
    }

    //Constructor takes both String variable of Miwok and Default language
    public Word(String miwokWord, String defaultWord){
        mMiwokWord = miwokWord;
        mDefaultWord = defaultWord;
    }

    public void setMiwokWord(String miwokWord){
        mMiwokWord = miwokWord;
    }

    public void setDefaultWord(String defaultWord){
        mDefaultWord = defaultWord;
    }

    public String getMiwokTranslation(){
        return mMiwokWord;
    }

    public String getDefaultTranslation(){
        return mDefaultWord;
    }
}
