package com.Frame.FloatingFrame;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class FloatingTouchListener implements View.OnTouchListener {
    private WindowManager.LayoutParams params;
    private WindowManager wm;
    private int initialX, initialY;
    private float touchX, touchY;

    public FloatingTouchListener(WindowManager.LayoutParams p, WindowManager w) {
        this.params = p; this.wm = w;
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = params.x; initialY = params.y;
                touchX = e.getRawX(); touchY = e.getRawY();
                return true;
            case MotionEvent.ACTION_MOVE:
                params.x = initialX + (int) (e.getRawX() - touchX);
                params.y = initialY + (int) (e.getRawY() - touchY);
                wm.updateViewLayout(v, params);
                return true;
        }
        return false;
    }
}
