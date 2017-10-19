package com.example.dew_dew.navigtiontoall.layoutBehaviour;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.dew_dew.navigtiontoall.R;

/**
 * Created by DEW_DEW on 10/19/2017.
 */

public class FancyLayoutBehaviour<V extends View> extends CoordinatorLayout.Behavior<V> {

    private int mmaxWidth;


    public FancyLayoutBehaviour() {
    }

    public FancyLayoutBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.CustomAttriBute);
        a.getDimension(R.styleable.CustomAttriBute_distanceEX,12);
        a.recycle();
    }


}
