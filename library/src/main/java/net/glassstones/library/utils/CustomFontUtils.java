package net.glassstones.library.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import net.glassstones.library.R;


/**
 * Created by norman on 3/8/15.
 * Adapted for Markit.
 */
public class CustomFontUtils {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public static void applyCustomFont(TextView customFontTextView, Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView);

        String fontName = attributeArray.getString(R.styleable.CustomTextView_font);

        // check if a special textStyle was used (e.g. extra bold)
        int textStyle = attributeArray.getInt(R.styleable.CustomTextView_textStyle, 0);

        // if nothing extra was used, fall back to regular android:textStyle parameter
        if (textStyle == 0) {
            textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);
        }

        Typeface customFont = selectTypeface(context, fontName, textStyle);
        customFontTextView.setTypeface(customFont);

        attributeArray.recycle();
    }

    private static Typeface selectTypeface(Context context, String fontName, int textStyle) {
        if (fontName.contentEquals(context.getString(R.string.font_name_fontawesome))) {
            return FontCache.getTypeface("fonts/fontawesome.ttf", context);
        }
        else if (fontName.contentEquals(context.getString(R.string.avenir_next_lT_pro))) {
            /*
            information about the TextView textStyle:
            http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
            */
            switch (textStyle) {
                case Typeface.BOLD: // bold
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-Bold.otf", context);

                case Typeface.ITALIC: // italic
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-CnIt.otf", context);

                case Typeface.BOLD_ITALIC: // bold italic
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-BoldCnIt.otf", context);

                case 10: // extra light, equals @integer/font_style_extra_light
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-UltLtCn.otf", context);

                case 11: // extra bold, equals @integer/font_style_extra_bold
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-HeavyCn.otf", context);

                case Typeface.NORMAL: // regular
                default:
                    return FontCache.getTypeface("fonts/"+"AvenirNextLTPro-MediumCn-Regular.otf", context);
            }
        }
        else {
            // no matching font found
            // return null so Android just uses the standard font (Roboto)
            return null;
        }
    }
}