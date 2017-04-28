package com.udacity.gradle.builditbigger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.contracts.IJokeListener;
import com.udacity.gradle.builditbigger.task.AsyncJokeRetriever;

import me.sethallen.jokeviewer.JokeViewerActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, IJokeListener {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Button jokeButton = (Button) root.findViewById(R.id.tell_joke_button);
        jokeButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        switch (v.getId()) {
            case R.id.tell_joke_button:
                new AsyncJokeRetriever(this).getJoke();
                break;
        }
    }

    @Override
    public void onJokeReceived(String joke) {
        Intent intent = new Intent(getContext(), JokeViewerActivity.class);
        intent.putExtra(JokeViewerActivity.ARG_JOKE, joke);

        startActivity(intent);
    }
}