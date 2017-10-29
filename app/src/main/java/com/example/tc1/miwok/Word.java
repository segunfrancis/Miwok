package com.example.tc1.miwok;

/**
 * Created by TC1 on 05/10/2017.
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    // Default translation for the word
    private String mDefaultTranslation;

    // Miwok translation for the word;
    private String mMiwokTranslation;

    // Image Resource ID for thw word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Constant value that represents no image was provided for this word
    private static final int NO_IMAGE_PROVIDED = -1;

    // Audio resource ID for the word
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    // Get default translation
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    // Get Miwok translation
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    // Get Image Resource ID
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    // Get Audio Resource ID
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}