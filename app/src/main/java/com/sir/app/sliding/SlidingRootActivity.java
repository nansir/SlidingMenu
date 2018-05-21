package com.sir.app.sliding;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sir.app.sliding.menu.DrawerAdapter;
import com.sir.app.sliding.menu.DrawerItem;
import com.sir.app.sliding.menu.SimpleItem;
import com.sir.app.sliding.menu.SpaceItem;
import com.sir.library.base.BaseActivity;
import com.sir.library.sliding.SlidingRootNavBuilder;

import java.util.Arrays;

/**
 * Created by zhuyinan on 2017/6/15.
 */

public class SlidingRootActivity extends BaseActivity implements DrawerAdapter.OnItemSelectedListener {


    Bundle saved;
    private String[] screenTitles;
    private Drawable[] screenIcons;

    @Override
    public int bindLayout() {
        return R.layout.activity_sliding_root;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setSwipeBackEnable(false);
        saved = savedInstanceState;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(true)
                .withSavedState(saved)
                .withMenuLayout(R.layout.item_menu_left_drawer)
                .inject();
    }

    @Override
    public void doBusiness(Context mContext) {
        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();


        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(0).setChecked(true),
                createItemFor(1),
                createItemFor(2),
                createItemFor(3),
                new SpaceItem(48),
                createItemFor(5)));

        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(0);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.white))
                .withTextTint(color(R.color.white))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    @Override
    public void onItemSelected(int position) {
        if (position == 5) {
            finish();
        }
    }
}
