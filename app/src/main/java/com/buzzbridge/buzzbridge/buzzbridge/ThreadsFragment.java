package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ryan on 12/16/2014.
 */
public class ThreadsFragment extends Fragment {

    public ThreadsFragment newThreadsFragment() {
        return new ThreadsFragment();
    }

    public ThreadsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.threads_fragment, container, false);
    }

}
