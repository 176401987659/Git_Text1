package com.example.git_text.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class VpAdapter extends PagerAdapter {
    private ArrayList<View> mViews;

    public VpAdapter(ArrayList<View> views) {

        mViews = views;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public void setViews(ArrayList<View> views) {
        mViews = views;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView(mViews.get(position));
    }
}
