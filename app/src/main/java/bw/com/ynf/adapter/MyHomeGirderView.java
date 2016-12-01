package bw.com.ynf.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bw.com.ynf.Bean.HomeRoot;
import bw.com.ynf.R;

/**
 * autour: 郭涛
 * date: $date$ $time$
 * update: $date$
 */

public class MyHomeGirderView extends BaseAdapter {
    private List<HomeRoot.DataBean.Ad5Bean> ad5;
    private Context context;
    private DisplayImageOptions options;
    public MyHomeGirderView(List<HomeRoot.DataBean.Ad5Bean> ad5, Context context, DisplayImageOptions options) {
             this.context=context;
             this.ad5=ad5;
             this.options=options;
    }
    @Override
    public int getCount() {
        return ad5.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(context, R.layout.home_girder, null);
        ImageView iv = (ImageView) inflate.findViewById(R.id.fragment1_item_tupian);
        TextView tv = (TextView) inflate.findViewById(R.id.fragment1_item_hanzi);
        ImageLoader.getInstance().displayImage(ad5.get(i).getImage(),iv,options);
        tv.setText(ad5.get(i).getTitle());
        return inflate;
    }
}
