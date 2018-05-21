package com.sir.app.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sir.app.sliding.widget.ResideLayout;
import com.sir.library.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by zhuyinan on 2017/4/26.
 */

public class ResideActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @BindView(R.id.resideLayout)
    ResideLayout resideLayout;

    @Override
    public int bindLayout() {
        return R.layout.activity_reside;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSwipeBackEnable(false);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(getTitle());
    }

    @Override
    public void doBusiness(Context mContext) {
        resideLayout.setEnabled(false);
    }

    public void toggleMenu(View view) {
        resideLayout.openPane();
    }
}
