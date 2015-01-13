package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Ryan on 12/16/2014.
 */
public class ThreadsFragment extends Fragment {
    LinearLayout threadLinLayout;
    private TextView conversationCounter;
    private Context context;

    public ThreadsFragment() {}
    public static ThreadsFragment newThreadsFragment() {
        ThreadsFragment threadFrag = new ThreadsFragment();
        return threadFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View v = inflater.inflate(R.layout.threads_fragment, container, false);
        threadLinLayout = (LinearLayout) v.findViewById(R.id.threads_container);
        View conversationCountView = inflater.inflate(R.layout.conversation_count, container, false);
        conversationCounter = (TextView) conversationCountView.findViewById(R.id.number_of_conv);
        threadLinLayout.addView(conversationCountView);
        return v;
    }

    public void addThread(ThreadsFragment frag, Context context, View parentView) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout threadLayoutRowView = (RelativeLayout) parentView.findViewById(R.id.thread_row_view);
        RelativeLayout enterThreadView = (RelativeLayout) parentView.findViewById(R.id.enter_thread);
        final Thread newThread = Thread.newInstance(threadLayoutRowView, enterThreadView);
        enterThreadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("enterThread", "onClick");
                FragmentManager fmanager = getFragmentManager();
                fmanager.beginTransaction().addToBackStack(null).add(R.id.threads_fragment_container, newThread, "threadFragment").commit();
            }
        });
        frag.getThreadLinLayout().addView(newThread.getThreadsLayoutRowView(), 0);
        MainActivity.getThreadsList().add(newThread);
        int size = MainActivity.getThreadsList().size();
        MainActivity.getThreadsFragment().setConversationCountText(size);
    }

    public void setConversationCountText(int val) {
        this.conversationCounter.setText(String.valueOf(val));
    }
    public LinearLayout getThreadLinLayout() {
        return this.threadLinLayout;
    }

}
