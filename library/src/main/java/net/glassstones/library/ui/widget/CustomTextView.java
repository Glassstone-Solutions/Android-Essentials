package net.glassstones.library.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import net.glassstones.library.utils.CustomFontUtils;


/**
 * Created by Thompson on 23/01/2016.
 * For Markit
 */
public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        if (!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            CustomFontUtils.applyCustomFont(this, context, attrs);
    }

}
