package com.example.allens.CreateAJavaLibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.JokeSmith;
import com.example.JokeWizard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewJoke = (TextView)findViewById(R.id.text_view_joke);
        JokeSmith jokeSmith = new JokeSmith();
        textViewJoke.setText(jokeSmith.getJoke());

        TextView textViewJokeWizard = (TextView)findViewById(R.id.text_view_joke_wizard);
        JokeWizard jokeWizard = new JokeWizard();
        textViewJokeWizard.setText(jokeWizard.getJoke());

    }
}
