package com.Frame.FloatingFrame;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

public class FloatingFrameInstance {
    private WindowManager wm;
    private WindowManager.LayoutParams params;
    private Context context;
    private View targetView;

    public FloatingFrameInstance(Context context) {
        this.context = context;
        this.wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    public FloatingFrameInstance setView(View view) {
        this.targetView = view;
        params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT
        );
        params.gravity = Gravity.TOP | Gravity.START;
        // Pasang listener drag
        view.setOnTouchListener(new FloatingTouchListener(params, wm));
        return this;
    }

    public void show() {
        if (targetView != null) wm.addView(targetView, params);
    }
}
