package com.example.tc1.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TC1 on 06/10/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

        // Resource Id for the background color for the list of words
    private int mColorResourceId;

    /**
     * Create a nwe {@link WordAdapter object}
     *
     * @param context is the current context (i.e. activity) that the adapter is being created in.
     * @param words is the list of {@link Word} to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
        }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            // Set the ImageVIew to the image resource specified in the current word
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the image is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageVIew (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // set the backgroundColor of the text_container TextView
        textContainer.setBackgroundColor(color);
        // return the whole list item layout (containing 2 text views)
        return listItemView;
    }
}