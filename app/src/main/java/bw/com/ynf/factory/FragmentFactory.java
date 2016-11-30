package bw.com.ynf.factory;

import android.support.v4.app.Fragment;

import java.util.HashMap;

import bw.com.ynf.fragment.CartFragment;
import bw.com.ynf.fragment.CategoryFragment;
import bw.com.ynf.fragment.HomeFragment;
import bw.com.ynf.fragment.MineFragment;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */

public class FragmentFactory {
    //集合
    public static HashMap<Integer, Fragment> fragmentMap = new HashMap<>();


    public static Fragment getFragment(int position) {
        Fragment fragment = fragmentMap.get(position);
        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CategoryFragment();
                break;
            case 2:
                fragment = new CartFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;
        }
        return fragment;
    }
}
