package net.glassstones.library.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import net.glassstones.library.utils.CustomFontUtils;

/**
 * Created by Thompson on 28/11/2015.
 */
public class CustomFontButton extends Button {
    public CustomFontButton(Context context) {
        super(context);


        CustomFontUtils.applyCustomFont(this, context, null);
    }


    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);


        CustomFontUtils.applyCustomFont(this, context, attrs);
    }


    public CustomFontButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


        CustomFontUtils.applyCustomFont(this, context, attrs);
    }
}
