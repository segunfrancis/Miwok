package com.example.tc1.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //ArrayList
        ArrayList<Word> words = new ArrayList<>();
//      words.add("One");
        Word w = new Word("one", "lutti");
        words.add(w);

        words.add(new Word("two", "otiiko"));
        words.add(new Word("three", "tolookosu"));
        words.add(new Word("four", "oyyisa"));
        words.add(new Word("five", "massokka"));
        words.add(new Word("six", "temmokka"));
        words.add(new Word("seven", "kenekaku"));
        words.add(new Word("eight", "kawinta"));
        words.add(new Word("nine", "wo'e"));
        words.add(new Word("ten", "na'aacha"));


//        LinearLayout rootView = (LinearLayout)findViewById(R.id.root_view);
        /**wordView.setText(words.get(0));
        rootView.addView(wordView);

        TextView wordView2 = new TextView(NumbersActivity.this);
        wordView2.setText(words.get(1));
        rootView.addView(wordView2);

        TextView wordView3 = new TextView(NumbersActivity.this);
        wordView3.setText(words.get(2));
        rootView.addView(wordView3);

        TextView wordView4 = new TextView(NumbersActivity.this);
        wordView4.setText(words.get(3));
        rootView.addView(wordView4);

        TextView text4 = (TextView)findViewById(R.id.text4);
        text4.setText(words.get(4));

        TextView text5 = (TextView)findViewById(R.id.text5);
        text5.setText(words.get(5));
        **/
        /**int index = 0;
        while (index < words.size()){
            TextView wordView = new TextView(NumbersActivity.this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index++;
        }
        for (int index = 0; index < words.size(); index += 1){
            TextView wordView = new TextView(NumbersActivity.this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }**/
        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}