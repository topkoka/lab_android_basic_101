package com.aditep.ex_v1;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

public class CustomViewGroup extends FrameLayout {
    private Button btnHello;

    public CustomViewGroup(@NonNull Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }


    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @RequiresApi(21)
    public CustomViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        //Inflate Layout Here
        inflate(getContext(), R.layout.sample_layout, this);
    }

    private void initInstances() {
        // findviewById here
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }

    public void setButtonText(String text) {
        btnHello.setText(text);
    }
}
