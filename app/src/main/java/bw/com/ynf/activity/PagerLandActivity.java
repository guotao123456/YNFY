package bw.com.ynf.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import bw.com.ynf.R;

public class PagerLandActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mVp;
    private List<View> mListVp;
    private SharedPreferences mSp;
    private Button mPass, mStart;
    private RadioButton mIv1, mIv2, mIv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_land);
        mSp = getSharedPreferences("guotao.xml", MODE_PRIVATE);
        if (mSp.getBoolean("guotao", false)) {
            Intent mIntent = new Intent(PagerLandActivity.this, ZhuyeActivity.class);
            startActivity(mIntent);
            finish();
        }
        //添加View
        addView();
        //控件初始化
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.pl_vp);
        mIv1 = (RadioButton) findViewById(R.id.pl_iv1);
        mIv2 = (RadioButton) findViewById(R.id.pl_iv2);
        mIv3 = (RadioButton) findViewById(R.id.pl_iv3);
        mPass = (Button) findViewById(R.id.pl_btn_pass);
        mStart = (Button) findViewById(R.id.pl_btn_start);
        mPass.setOnClickListener(this);
        mStart.setOnClickListener(this);
        //自建设配器
        mVp.setAdapter(new PagerAdapter() {
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                // TODO Auto-generated method stub
                container.removeView(mListVp.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                View view = mListVp.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mListVp != null ? mListVp.size() : 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        mIv1.setChecked(true);
                        mIv2.setChecked(false);
                        mIv3.setChecked(false);
                        break;
                    case 1:
                        mIv1.setChecked(false);
                        mIv2.setChecked(true);
                        mIv3.setChecked(false);
                        break;
                    case 2:
                        mIv1.setChecked(false);
                        mIv2.setChecked(false);
                        mIv3.setChecked(true);
                        break;
                }
                //判断不为空且是最后一张logo图的时候
                if (mListVp != null && position == 2) {
                    mStart.setVisibility(View.VISIBLE);
                    mPass.setVisibility(View.INVISIBLE);
                    RelativeLayout layout = (RelativeLayout) mListVp.get(position).findViewById(R.id.logo_pl5);
                    layout.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            addSh();
                        }
                    });
                } else {
                    mStart.setVisibility(View.INVISIBLE);
                    mPass.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void addView() {
        mListVp = new ArrayList<>();
        View view1 = View.inflate(getApplicationContext(), R.layout.logo_pl1, null);
        View view2 = View.inflate(getApplicationContext(), R.layout.logo_pl2, null);
        View view3 = View.inflate(getApplicationContext(), R.layout.logo_pl5, null);

        mListVp.add(view1);
        mListVp.add(view2);
        mListVp.add(view3);

    }

    @Override
    public void onClick(View view) {
        addSh();
    }

    //保存
    private void addSh() {
        SharedPreferences.Editor editor = mSp.edit();
        editor.putBoolean("guotao", true);
        editor.commit();
        Intent mIntent = new Intent(PagerLandActivity.this, ZhuyeActivity.class);
        startActivity(mIntent);
        finish();
    }
}

