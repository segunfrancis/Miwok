package com.example.tc1.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //ArrayList
        ArrayList<Word> words = new ArrayList<>();
//      words.add("One");
        Word w = new Word("Where are you going?", "minto wuskus");
        words.add(w);

        words.add(new Word("What is your name?", "otiiko"));
        words.add(new Word("My name is...", "oyaaset"));
        words.add(new Word("How are you?", "oyyisa"));
        words.add(new Word("I'm feeling good", "kuchi achit"));
        words.add(new Word("Are you coming?", "temmokka"));
        words.add(new Word("Yes, I;m coming", "kenekaku"));
        words.add(new Word("I'm coming", "kawinta"));
        words.add(new Word("Let's go", "wo'e"));
        words.add(new Word("Come here", "na'aacha"));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
