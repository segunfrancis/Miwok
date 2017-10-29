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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
