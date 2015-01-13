package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private RelativeLayout mainActivityLayout;
    private static ThreadsFragment threadsFragment;
    private static LinearLayout mainThreadsLayout;
    private static ArrayList<Thread> threadsList;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        threadsList = new ArrayList<Thread>();

        FragmentManager fmanager = getFragmentManager();
        threadsFragment = ThreadsFragment.newThreadsFragment();
        fmanager.beginTransaction().add(R.id.threads_fragment_container,
                threadsFragment, "threadsFragment").commit();
        mainActivityLayout = (RelativeLayout) findViewById(R.id.threads_fragment_container);
        mainThreadsLayout = (LinearLayout) findViewById(R.id.threads_container);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_add_thread) {
            Toast toast = Toast.makeText(getApplicationContext(), "new", Toast.LENGTH_SHORT);
            toast.show();
            View parentView = inflater.inflate(R.layout.thread_fragment_row_view, mainThreadsLayout, false);
            getThreadsFragment().addThread(threadsFragment, getApplicationContext(), parentView);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // getters and setters
    public static ArrayList<Thread> getThreadsList() {
        return threadsList;
    }
    public static ThreadsFragment getThreadsFragment() {
        return threadsFragment;
    }
}
