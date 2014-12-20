package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Ryan on 12/16/2014.
 */
public class ThreadsFragment extends Fragment {
    LinearLayout threadLinLayout;

    public ThreadsFragment() {}
    public static ThreadsFragment newThreadsFragment() {
        ThreadsFragment threadFrag = new ThreadsFragment();
        return threadFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.threads_fragment, container, false);
        threadLinLayout = (LinearLayout) v.findViewById(R.id.threads_container);
        return v;
    }

    public static void addThread(ThreadsFragment frag, Context context, LinearLayout threadsContainer) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View thread = inflater.inflate(R.layout.thread_fragment_row_view, threadsContainer, false);
        frag.threadLinLayout.addView(thread);
        // create thread here

    }

}
