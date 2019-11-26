package com.rk.topscomm.instruction;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends BaseActivity {

    private static final String TAG = FullscreenActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private TextView mPageNumTextView;

    private static final int[] IMAGES = new int[]{
            R.drawable.introduce_1,
            R.drawable.introduce_2,
            R.drawable.introduce_3,
            R.drawable.introduce_4,
            R.drawable.introduce_5,
            R.drawable.introduce_6,
            R.drawable.introduce_7,
            R.drawable.introduce_8,
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
