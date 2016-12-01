package bw.com.ynf.fragment;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;
import java.util.List;

import bw.com.ynf.Bean.HomeRoot;
import bw.com.ynf.R;
import bw.com.ynf.adapter.MyHomeGirderView;
import bw.com.ynf.basefragemnt.BaseFragment;
import bw.com.ynf.basefragemnt.Basedata;
import bw.com.ynf.utils.CommonUtils;
import bw.com.ynf.utils.ImageLoaderUtils;
import bw.com.ynf.utils.TiaoZhuanUtil;
import bw.com.ynf.utils.URLUtils;
import bw.com.ynf.view.MyHomeGirder;
import bw.com.ynf.view.MyRoolViewPager;
import bw.com.ynf.view.ShowingPage;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */
public class HomeFragment extends BaseFragment {
    private DisplayImageOptions options = ImageLoaderUtils.initOptions();
    public String data;
    private MyHomeData myHomeData;
    private HomeRoot homeRoot;
    /**轮播图图片集合
     * 小点图片数组
     */
    int[] dotArray = new int[]{R.mipmap.page_indicator_focused, R.mipmap.page_indicator_unfocused};
    ArrayList<String> imgUrlList = new ArrayList<>();
    ArrayList<ImageView> dotList = new ArrayList<>();
    private LinearLayout ll_dots;
    private MyRoolViewPager myRoolViewPager;
    private MyHomeGirder myHomeGirder1;
    private TextView benzhou;
    private MyHomeGirder aaaa;

    @Override
    protected void onLoad() {
        myHomeData = new MyHomeData();
        myHomeData.getData(URLUtils.homeUrl, URLUtils.homeArgs, 0, Basedata.NORMALTIME);
    }
    @Override
    public View createSuccessView() {
        View view = initView();
        //轮播的方法
        initRoolViewPager();
        //图标请求 每日签单....
        initRoolTubiao();
        //本周热销
        initRoolBenZhou();
        return view;
    }
    /**
     * 初始化viewPager轮播图
     */
    private void initRoolViewPager() {
        final List<HomeRoot.DataBean.Ad1Bean> ad1 = homeRoot.getData().getAd1();
        for (int i = 0; i < ad1.size(); i++) {
            imgUrlList.add(ad1.get(i).getImage());
        }
        initDots(ad1);
        myRoolViewPager.initData(imgUrlList, dotArray, dotList);
        myRoolViewPager.startViewPager();
        myRoolViewPager.setOnPageClickListener(new MyRoolViewPager.OnPageClickListener() {
            @Override
            public void setOnPage(int position) {
                TiaoZhuanUtil.tiaoZhuan(getActivity(), ad1.get(position).getAd_type_dynamic_data());
            }
        });
    }
    /**
     * 初始化小点
     * @param ad1
     */
    private void initDots(List<HomeRoot.DataBean.Ad1Bean> ad1) {
        dotList.clear();
        ll_dots.removeAllViews();
        for (int i = 0; i < ad1.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            if (i == 0) {
                imageView.setImageResource(dotArray[0]);
            } else {
                imageView.setImageResource(dotArray[1]);
            }
            dotList.add(imageView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(CommonUtils.dip2px(10), CommonUtils.dip2px(5), CommonUtils.dip2px(10), CommonUtils.dip2px(5));
            ll_dots.addView(imageView, params);
        }
    }
    /**
     * 每日签到
     * 积分商城
     * 兑换专区
     * 真伪查询
     */
    private void initRoolTubiao() {
         final List<HomeRoot.DataBean.Ad5Bean> ad5=homeRoot.getData().getAd5();
          MyHomeGirderView myHomeGirderView=new MyHomeGirderView(ad5,getActivity(),options);
          myHomeGirder1.setAdapter(myHomeGirderView);
          myHomeGirder1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TiaoZhuanUtil.tiaoZhuan(getActivity(), ad5.get(i).getAd_type_dynamic_data());
            }
        });
    }

    /**
     * 本周热销
     */
    private void initRoolBenZhou() {
        HomeRoot.DataBean.BestSellersBean bestSellersBean = homeRoot.getData().getBestSellers().get(0);


    }





















    @NonNull
    /**
     * 找控件
     */
    private View initView() {
        View view = CommonUtils.inflate(R.layout.home_item);
        ll_dots = (LinearLayout) view.findViewById(R.id.ll_dots);
        myRoolViewPager = (MyRoolViewPager) view.findViewById(R.id.myRoolHome);
        myHomeGirder1 = (MyHomeGirder) view.findViewById(R.id.myHomeGirder1);
        benzhou = (TextView) view.findViewById(R.id.benzhou);
        return view;
    }
    /**
     * 请求网络
     */
    class MyHomeData extends Basedata {
        @Override
        public void setResultData(String data) {
            //先设置数据
            HomeFragment.this.data = data;
            //data有可能为空
            //再展示
            Gson gson = new Gson();
            homeRoot = gson.fromJson(data, HomeRoot.class);
            HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        }
        @Override
        protected void setResulttError(ShowingPage.StateType stateLoadError) {
            //失败
            HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }
}
