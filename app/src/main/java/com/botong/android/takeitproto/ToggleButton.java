package com.botong.android.takeitproto;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by cob_macpro on 2015. 1. 26..
 */
public class ToggleButton extends LinearLayout{

    public interface OnValueChangedListener {
        public void onValueChanged(int value);
    }

    OnValueChangedListener listener;
    Context context;

    public ToggleButton(Context context) {
        super(context, null);
        this.context = context;
    }
}
