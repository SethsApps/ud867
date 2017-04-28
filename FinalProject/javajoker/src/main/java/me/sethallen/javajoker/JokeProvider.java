package me.sethallen.javajoker;

import hudson.plugins.chucknorris.FactGenerator;

public class JokeProvider {

    private static final FactGenerator mChuckNorrisJokeGenerator = new FactGenerator();

    public String makeMeLaugh()
    {
        return mChuckNorrisJokeGenerator.random();
    }
}
