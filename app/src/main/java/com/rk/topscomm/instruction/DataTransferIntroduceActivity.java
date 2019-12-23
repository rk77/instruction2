package com.rk.topscomm.instruction;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class DataTransferIntroduceActivity extends BaseActivity {

    private static final String TAG = DataTransferIntroduceActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private TextView mPageNumTextView;

    private static final int[] IMAGES = new int[]{
            R.drawable.transfer_1,
            R.drawable.transfer_2,
            R.drawable.transfer_3,
            R.drawable.transfer_4,
            R.drawable.transfer_5,
            R.drawable.transfer_6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        mViewPager = findViewById(R.id.view_pager);
        mPageNumTextView = findViewById(R.id.page_number);
        mPageNumTextView.setText("1/" + IMAGES.length);

//        mViewPager.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        ViewPagerAdapter vpa = new ViewPagerAdapter(this, IMAGES);
        mViewPager.setAdapter(vpa);
        mViewPager.setPageMargin(30);
        mViewPager.setOffscreenPageLimit(7);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPageNumTextView.setText(position + 1 + "/" + IMAGES.length);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
