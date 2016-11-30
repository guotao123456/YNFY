package bw.com.ynf.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */

public class MyNoViewPager extends ViewPager {
    public MyNoViewPager(Context context) {
        super(context);
    }
    public MyNoViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
