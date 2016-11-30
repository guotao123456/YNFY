package bw.com.ynf.fragment;

import android.view.View;

import bw.com.ynf.basefragemnt.BaseFragment;
import bw.com.ynf.utils.LogUtils;
import bw.com.ynf.view.ShowingPage;
/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */
public class CategoryFragment extends BaseFragment {
    private static final String TAG = "CategoryFragment";
    @Override
    protected void onLoad() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CategoryFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
                LogUtils.e(TAG, "category----" + "---------");
            }
        }.start();
    }
    @Override
    protected View createSuccessView() {

        return null;
    }


}
