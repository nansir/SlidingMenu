package com.sir.library.sliding.util;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import com.sir.library.sliding.SlidingRootNavLayout;


public class ActionBarToggleAdapter extends DrawerLayout {

    private SlidingRootNavLayout adaptee;

    public ActionBarToggleAdapter(Context context) {
        super(context);
    }

    @Override
    public void openDrawer(int gravity) {
        adaptee.openMenu();
    }

    @Override
    public void closeDrawer(int gravity) {
        adaptee.closeMenu();
    }

    @Override
    public boolean isDrawerVisible(int drawerGravity) {
        return !adaptee.isMenuHidden();
    }

    @Override
    public int getDrawerLockMode(int edgeGravity) {
        if (adaptee.isMenuLocked() && adaptee.isMenuHidden()) {
            return DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
        } else if (adaptee.isMenuLocked() && !adaptee.isMenuHidden()) {
            Log.e("tag","else if");
            return DrawerLayout.LOCK_MODE_LOCKED_OPEN;
        } else {
            Log.e("tag","else");
            return DrawerLayout.LOCK_MODE_UNLOCKED;
        }
    }

    public void setAdaptee(SlidingRootNavLayout adaptee) {
        this.adaptee = adaptee;
    }
}
