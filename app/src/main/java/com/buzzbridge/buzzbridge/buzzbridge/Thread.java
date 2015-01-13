package com.buzzbridge.buzzbridge.buzzbridge;

import android.app.Fragment;
import android.app.FragmentManager;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Ryan on 12/19/2014.
 */
public class Thread extends Fragment {

    private RelativeLayout enterThreadView;
    private RelativeLayout threadsLayoutRowView;
    private EditText messageView;
    private ImageView sendButton;
    private ImageView attachmentButton;

    public static Thread newInstance(RelativeLayout threadsLayoutRowView, RelativeLayout enterThreadView) {
        Thread newThread = new Thread();
        newThread.setThreadsLayoutRowView(threadsLayoutRowView);
        newThread.setEnterThreadView(enterThreadView);
        return newThread;
    }

    public Thread() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thread, container, false);
        messageView = (EditText) v.findViewById(R.id.message_view);
        sendButton = (ImageView) v.findViewById(R.id.send_button);
        attachmentButton = (ImageView) v.findViewById(R.id.attachment);
        return v;
    }

    // Getters and Setters
    public void setThreadsLayoutRowView(RelativeLayout threadsLayoutRowView) {
        this.threadsLayoutRowView = threadsLayoutRowView;
    }
    public RelativeLayout getThreadsLayoutRowView() {
        return this.threadsLayoutRowView;
    }
    public EditText getMessageView() {return this.messageView;}
    public ImageView getSendButton() {return this.sendButton;}
    public ImageView getAttachmentButton() {return this.attachmentButton;}
    public void setEnterThreadView(RelativeLayout enterThreadView) {this.enterThreadView = enterThreadView;}
    public RelativeLayout getEnterThreadView() {return this.enterThreadView;}

}
