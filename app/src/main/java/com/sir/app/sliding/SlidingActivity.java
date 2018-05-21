package com.sir.app.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sir.app.sliding.widget.SlidingLayout;
import com.sir.library.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by zhuyinan on 2017/4/26.
 */

public class SlidingActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    SlidingLayout mMenu;

    @Override
    public int bindLayout() {
        return R.layout.activity_sliding;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSwipeBackEnable(false);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(getTitle());
        mMenu = findViewById(R.id.id_menu);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    public void toggleMenu(View view) {
        mMenu.toggle();
    }
}
