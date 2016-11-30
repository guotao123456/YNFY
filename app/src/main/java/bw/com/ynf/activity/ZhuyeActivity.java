package bw.com.ynf.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import bw.com.ynf.R;
import bw.com.ynf.factory.FragmentFactory;
import bw.com.ynf.view.MyNoViewPager;
public class ZhuyeActivity extends AppCompatActivity {
    private MyNoViewPager viewPager;
    private RadioGroup rg_zhuye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
        viewPager = (MyNoViewPager) findViewById(R.id.vp_zhuye);
        rg_zhuye = (RadioGroup) findViewById(R.id.rg_zhuye);
        //设置ViewPager适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return FragmentFactory.getFragment(position);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        //对radioGroup设置监听
        rg_zhuye.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_home_page:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_category:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_cart:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_mine:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }
}
