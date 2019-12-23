package com.rk.topscomm.instruction;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ViewPager mViewPager;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick 0");
                Intent i = new Intent(MainActivity.this, FullscreenActivity.class);
                startActivity(i);
            }
        });
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_2), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick 1");
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_3), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick 2");
                Intent i = new Intent(MainActivity.this, DataTransferIntroduceActivity.class);
                startActivity(i);
            }
        });
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mFragmentCardShadowTransformer.enableScaling(true);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
