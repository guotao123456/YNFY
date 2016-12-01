package bw.com.ynf.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */

public class MyHomeGirder extends GridView{
    public MyHomeGirder(Context context) {
        super(context);
    }
    public MyHomeGirder(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyHomeGirder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /** 对GirdView进行计算高度
    * @param widthMeasureSpec
    * @param heightMeasureSpec
    */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
