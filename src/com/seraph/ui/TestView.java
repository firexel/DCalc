package com.seraph.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.seraph.R;

/**
 * User: anaumov
 * Date: 7/27/13
 * Time: 5:10 PM
 */
public class TestView extends FrameLayout {

    private final TextView textView;

    public TestView(Context context) {
        super(context);
        ViewGroup view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.view_expression, this);
        textView = (TextView) view.findViewById(R.id.view_text);
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
