package com.sir.app.sliding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.sir.library.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSwipeBackEnable(false);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.btn_reside, R.id.btn_sliding, R.id.btn_sliding_root})
    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.btn_reside:
                getOperation().forward(ResideActivity.class);
                break;
            case R.id.btn_sliding:
                getOperation().forward(SlidingActivity.class);
                break;
            case R.id.btn_sliding_root:
                getOperation().forward(SlidingRootActivity.class);
                break;
        }
    }
}
