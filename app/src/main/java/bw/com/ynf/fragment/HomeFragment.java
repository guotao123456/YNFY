package bw.com.ynf.fragment;

import android.view.View;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bw.com.ynf.basefragemnt.BaseFragment;
import bw.com.ynf.utils.LogUtils;
import bw.com.ynf.view.ShowingPage;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */
public class HomeFragment extends BaseFragment{
    private String s;
    @Override
    protected void onLoad() {
        RequestParams re=new RequestParams("http://m.yunifang.com/yunifang/mobile/home?random=59676&encode=62d458fefce9c740359873cc19b05188");
        //去加载
        x.http().get(re, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //先赋值---
                HomeFragment.this.s=s;
                HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                LogUtils.e("AAAAA","success-------cart-"+s);
            }
            @Override
            public void onError(Throwable throwable, boolean b) {
            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });

    }
    @Override
    protected View createSuccessView() {
        LogUtils.e("AAAAA","create-------cart-"+s);
        TextView textView =new TextView(getContext());
        textView.setText(s);
        return textView;
    }

}
