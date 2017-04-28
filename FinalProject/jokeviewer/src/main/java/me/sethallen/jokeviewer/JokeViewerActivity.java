package me.sethallen.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    public static final String ARG_JOKE = "argument-joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        TextView textView = (TextView) findViewById(R.id.text_view_joke);
        String theJoke = getIntent().getStringExtra(ARG_JOKE);
        textView.setText(theJoke);
    }
}