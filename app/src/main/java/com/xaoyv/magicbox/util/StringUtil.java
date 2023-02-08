package com.xaoyv.magicbox.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static int parseInt(String s) {
        try {
            if (s.contains(".")) {
                s = s.substring(0, s.indexOf("."));
            }
            return Integer.parseInt(s);
        } catch (Exception ignore) {
            return 0;
        }
    }

    public static long parseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static int parseInt(String s, int defaultValue) {
        try {
            if (s.contains(".")) {
                s = s.substring(0, s.indexOf("."));
            }
            return Integer.parseInt(s);
        } catch (Exception ignore) {
            return defaultValue;
        }
    }

    public static float parseFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0F;
    }


    /**
     * mChatTipsTv.setMovementMethod(LinkMovementMethod.getInstance());
     * <p>
     * tv_tv.movementMethod = LinkMovementMethod.getInstance()
     *
     * @param textColor eg:Color.WHITE , 0xffFFFFFF
     */
    public static SpannableString buildClickSpannableString(@NotNull String text, @ColorInt int textColor, @Nullable TextClickListener listener) {
        SpannableString commentSpannable = new SpannableString(text);
        commentSpannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //跳转隐私政策
                if (listener != null) {
                    listener.onClick();
                }
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(textColor);
                ds.setUnderlineText(false);
            }
        }, 0, commentSpannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return commentSpannable;
    }

    /**
     * 将过万的数值的转换成x.x万
     */
    public static String changeTenThousand(String number) {
        int num = parseInt(number);
        if (num < 10000) {
            return String.valueOf(number);
        }
        double value = 1.0 * num / 10000;
        String format = String.format("%.1f万", value);
        if (format.contains(".0")) {
            format = format.replace(".0", "");
        }
        return format;
    }

    /**
     * unicode 转 string
     *
     * @param uni
     * @return
     */
    public static String unicode2String(String uni) {
        try {
            Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
            Matcher matcher = pattern.matcher(uni);
            char ch;
            while (matcher.find()) {
                //group 6728
                String group = matcher.group(2);
                //ch:'木' 26408
                ch = (char) Integer.parseInt(group, 16);
                //group1 \u6728
                String group1 = matcher.group(1);
                uni = uni.replace(group1, ch + "");
            }
            return uni;
        } catch (Exception e) {
            e.printStackTrace();
            return uni;
        }
    }

    public static void setText(@Nullable TextView textView, @Nullable String text) {
        if (textView == null) {
            return;
        }
        if (text == null) {
            text = "";
        }
        textView.setText(text);
    }

    public static void setText(@Nullable TextView textView, int text) {
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(text));
    }

    public static void setText(@Nullable TextView textView, @Nullable CharSequence text) {
        if (textView == null) {
            return;
        }
        if (text == null) {
            text = "";
        }
        textView.setText(text);
    }

    public interface TextClickListener {
        void onClick();
    }
}
