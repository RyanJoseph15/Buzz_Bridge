package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends Activity {

    RelativeLayout mainActivityLayout;
    static ThreadsFragment threadsFragment;
    LinearLayout mainThreadsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

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
            ThreadsFragment.addThread(threadsFragment, getApplicationContext(), mainThreadsLayout);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {

        mainActivityLayout = (RelativeLayout) findViewById(R.id.threads_fragment_container);
        mainThreadsLayout = (LinearLayout) findViewById(R.id.threads_container);
        FragmentManager fmanager = getFragmentManager();
        threadsFragment = ThreadsFragment.newThreadsFragment();
        fmanager.beginTransaction().add(R.id.threads_fragment_container,
                threadsFragment, "threadsFragment").commit();

    }
}
