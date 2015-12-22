package net.glassstones.library.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import net.glassstones.library.R;

/**
 * Created by Thompson on 28/11/2015.
 */
public class CustomFontUtils {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public static void applyCustomFont(TextView customFontTextView, Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomFontTextView);

        String fontName = attributeArray.getString(R.styleable.CustomFontTextView_font);
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", 0);


        Typeface customFont = selectTypeface(context, fontName, textStyle);
        customFontTextView.setTypeface(customFont);


        attributeArray.recycle();
    }

    private static Typeface selectTypeface(Context context, String fontName, int textStyle) {
        if (fontName.contentEquals(context.getString(R.string.font_name_fontawesome))) {
            return FontCache.getTypeface("fontawesome.ttf", context);
        } else if (fontName.contentEquals(context.getString(R.string.font_name_source_sans_pro))) {
            /*
            information about the TextView textStyle:
            http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
            */
            switch (textStyle) {
                case 1: // bold
                    return FontCache.getTypeface("SourceSansPro-Bold.ttf", context);


                case 2: // italic
                    return FontCache.getTypeface("SourceSansPro-Italic.ttf", context);


                case 0: // regular
                default:
                    return FontCache.getTypeface("SourceSansPro-Regular.ttf", context);
            }
        } else {
            // no matching font found
            // return null so Android just uses the standard font (Roboto)
            return null;
        }

    }

}
