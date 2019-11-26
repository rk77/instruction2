package com.rk.topscomm.instruction;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIDs;

    public ViewPagerAdapter(Context context, int[] datas){
        mImageIDs = datas;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageIDs.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView mImageView = createImageView(mContext, position);
        container.addView(mImageView);
        return mImageView;
//        CardView card = createCardView(mContext, position);
//        container.addView(card);
//        return card;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


    private ImageView createImageView(Context mContext, int position) {
        RoundImageView imageview = new RoundImageView(mContext);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        imageview.setLayoutParams(layoutParams);
        imageview.setImageResource(mImageIDs[position]);
        imageview.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageview;
    }

    private CardView createCardView(Context context, int positon) {
        CardView card = new CardView(context);
        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        card.setLayoutParams(layoutParams);
        card.setRadius(100);
        card.setBackgroundResource(mImageIDs[positon]);
        return card;

    }
}
