package com.Frame.FloatingFrame;
import android.content.Context;
import android.view.View;

public class FloatingFrame {
    public static FloatingFrameInstance with(Context context) {
        return new FloatingFrameInstance(context);
    }
}
