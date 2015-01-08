package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Ryan on 12/19/2014.
 */
public class Thread extends Fragment {

    private RelativeLayout enterThreadView;
    private View threadsLayoutRowView;

    public View getThreadsLayoutRowView() {return this.threadsLayoutRowView;}

    public static Thread newInstance(ViewGroup threadsContainer) {
        Thread newThread = new Thread();

        return newThread;
    }

    public Thread() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thread, container, false);
        return v;
    }

}
