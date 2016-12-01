package bw.com.ynf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import bw.com.ynf.R;
import bw.com.ynf.activity.LoginActivity;
import bw.com.ynf.basefragemnt.BaseFragment;
import bw.com.ynf.view.CricleImageView;
import bw.com.ynf.view.ItemListView;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    private boolean mFolg;
    private String mUser;
    private TextView mUser_name;
    private Button mQiandao;
    private Button mBtn_login;
    private String mUserIcon;
    private String mUserId;
    private String mUserName;
    private CricleImageView mIm_user;
    private ImageLoader mLoder;
    private boolean mFlag;
    @Override
    protected void onLoad() {
    }
    @Override
    protected View createSuccessView() {
         return null;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.mine_item, null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //        初始化控件
        initview();
    }
    private void initview() {
        ItemListView ilv_order = (ItemListView) getView().findViewById(R.id.my_order);
        ilv_order.setOnClickListener(this);
        ItemListView ilv_vip = (ItemListView) getView().findViewById(R.id.my_vip);
        ilv_vip.setOnClickListener(this);
        ItemListView ilv_invite = (ItemListView) getView().findViewById(R.id.my_invite);
        ilv_invite.setOnClickListener(this);
        ItemListView ilv_coupon = (ItemListView) getView().findViewById(R.id.my_coupon);
        ilv_coupon.setOnClickListener(this);
        ItemListView ilv_lottery = (ItemListView) getView().findViewById(R.id.my_lottery);
        ilv_lottery.setOnClickListener(this);
        ItemListView ilv_personal_center = (ItemListView) getView().findViewById(R.id.my_personal_center);
        ilv_personal_center.setOnClickListener(this);
        ItemListView ilv_collection = (ItemListView) getView().findViewById(R.id.my_collection);
        ilv_collection.setOnClickListener(this);
        mUser_name = (TextView) getView().findViewById(R.id.tv_user_name);
        mQiandao = (Button) getView().findViewById(R.id.btn_qiandao);
        mBtn_login = (Button) getView().findViewById(R.id.btn_user_login);
        //对登录设置点击事件
        mBtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        mIm_user = (CricleImageView) getView().findViewById(R.id.image_user);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_order:
                Toast.makeText(getActivity(), "我的订单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_vip:
                Toast.makeText(getActivity(), "会员福利", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_invite:
                Toast.makeText(getActivity(), "邀请有礼", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_coupon:
                Toast.makeText(getActivity(), "我的现金券", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_lottery:
                Toast.makeText(getActivity(), "我的抽奖单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_personal_center:
                Toast.makeText(getActivity(), "联系客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_collection:
                Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_qiandao:
                Toast.makeText(getActivity(), "签到成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
