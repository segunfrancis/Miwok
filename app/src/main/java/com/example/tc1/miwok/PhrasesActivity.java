package com.example.tc1.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList
        final ArrayList<Word> words = new ArrayList<>();
//      words.add("One");
        Word w = new Word("Where are you going?", "minto wuskus", R.raw.phrase_where_are_you_going);
        words.add(w);

        words.add(new Word("What is your name?", "otiiko", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset", R.raw.phrase_my_name_is));
        words.add(new Word("How are you?", "oyyisa", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "temmokka", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming", "kenekaku", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming", "kawinta", R.raw.phrase_im_coming));
        words.add(new Word("Let's go", "wo'e", R.raw.phrase_lets_go));
        words.add(new Word("Come here", "na'aacha", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                // Release the media player if it currently exists because we are about
                // to play a different sound file.
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource
                // associated with te current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release
                // the media player once the sound has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     *  Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be correctly playing a sound.
        if(mMediaPlayer != null){
            // Regardless of the current state of the media player, release its
            // resources because we no longer need it
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media
            // player is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}