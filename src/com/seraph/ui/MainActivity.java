package com.seraph.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.seraph.R;

/**
 * User: anaumov
 * Date: 7/27/13
 * Time: 2:08 PM
 */
public class MainActivity extends Activity {


    public static final int SCROLL_DURATION = 300;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new SuperSimpleAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                listView.post(new Runnable() {
                    public void run() {
                        int count = listView.getChildCount();
                        for (int i = 0; i < count; i++) {
                            View animView = listView.getChildAt(i);
                            if (animView != view) {
                                animView.animate()
                                        .setDuration(SCROLL_DURATION)
                                        .setInterpolator(new AccelerateDecelerateInterpolator())
                                        .alpha(0)
                                        .withLayer()
                                        .start();
                            } else {
                                animView.animate()
                                        .setDuration(SCROLL_DURATION)
                                        .setInterpolator(new AccelerateDecelerateInterpolator())
                                        .translationYBy(-view.getY())
                                        .withLayer()
                                        .start();
                            }
                        }
                    }
                });
            }
        });
    }

    private class SuperSimpleAdapter extends BaseAdapter {
        public int getCount() {
            return 100;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TestView view;
            if (convertView == null) {
                view = new TestView(parent.getContext());
            } else {
                view = (TestView) convertView;
            }
            view.setText(String.format("Item #%d", position));
            return view;
        }
    }
}
