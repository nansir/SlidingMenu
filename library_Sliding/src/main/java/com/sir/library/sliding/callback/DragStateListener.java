package com.sir.library.sliding.callback;


public interface DragStateListener {

    void onDragStart();

    void onDragEnd(boolean isMenuOpened);
}
