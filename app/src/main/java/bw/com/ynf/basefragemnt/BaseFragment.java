package bw.com.ynf.basefragemnt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bw.com.ynf.view.ShowingPage;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */

public abstract class BaseFragment extends Fragment {
    private ShowingPage showingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //进行加载
        //进行抽象
        showingPage = new ShowingPage(getContext()) {
            @Override
            protected void onload() {
                //进行加载
                //进行抽象

            }

            @Override
            public View createSuccessView() {
                return BaseFragment.this.createSuccessView();
            }
        };
        BaseFragment.this.onLoad();
        return showingPage;
    }
    /**
     * 加载
     */
    protected abstract void onLoad();

    /**
     * 展示成功界面
     */
    protected abstract View createSuccessView();

    /**
     * 对外提供方法，调用展示界面
     *
     * @param stateType
     */
    public void showCurrentPage(ShowingPage.StateType stateType) {
        //调用showingPage的方法
        if (showingPage != null) {
            showingPage.showCurrentPage(stateType);
        }

    }
}
