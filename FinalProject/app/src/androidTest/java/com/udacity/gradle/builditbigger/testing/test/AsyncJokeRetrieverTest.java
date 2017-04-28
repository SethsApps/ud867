package com.udacity.gradle.builditbigger.testing.test;

import android.test.UiThreadTest;

import com.udacity.gradle.builditbigger.contracts.IJokeListener;
import com.udacity.gradle.builditbigger.task.AsyncJokeRetriever;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncJokeRetrieverTest extends TestCase implements IJokeListener {

    private AsyncJokeRetriever mAsyncJokeRetriever;
    private CountDownLatch     mSignal;
    private String             mJoke;

    protected void setUp() throws Exception {
        super.setUp();

        mSignal             = new CountDownLatch(1);
        mAsyncJokeRetriever = new AsyncJokeRetriever(this);
    }

    @UiThreadTest
    public void testGetJoke() throws InterruptedException
    {
        mAsyncJokeRetriever.getJoke();
        mSignal.await(30, TimeUnit.SECONDS);

        assertNotNull(mJoke);
        assertFalse(mJoke.equals(""));
    }

    @Override
    public void onJokeReceived(String joke) {
        mJoke = joke;
        mSignal.countDown();
    }
}