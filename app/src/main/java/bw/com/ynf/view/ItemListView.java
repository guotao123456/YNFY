package bw.com.ynf.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import bw.com.ynf.R;

/**
 * 自定义的RelativeLayout控件 对listView展示进行设置
 */
public class ItemListView extends RelativeLayout {
    private ImageView LeftImage, RightButton;
    private TextView TitleText;
    private OnrightClickListener mListener;

    public interface OnrightClickListener {
        public void OnRightButtonClickListener();
    }

    //实现三个方法
    public ItemListView(Context context) {
        this(context, null);
    }

    //在第二的方法里面写逻辑
    public ItemListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        //找出相应的布局文件
        View inflate = LayoutInflater.from(context).inflate(R.layout.user_itemview, this);
        //找控件
        LeftImage = (ImageView) findViewById(R.id.im_myleftview);
        TitleText = (TextView) findViewById(R.id.tv_myview);
        RightButton = (ImageView) findViewById(R.id.im_myrightview);
        //点击事件
        inflate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.OnRightButtonClickListener();
                }
            }
        });
        //设置相应的文件资源attrs，并赋值
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.itemListView);
        int leftimage = ta.getResourceId(R.styleable.itemListView_leftImage, 0);
        String title = ta.getString(R.styleable.itemListView_titleText);
        int rightback = ta.getResourceId(R.styleable.itemListView_rightButton, 0);
        int textcolor = ta.getColor(R.styleable.itemListView_titleColor, 0);
        float textsize = ta.getDimension(R.styleable.itemListView_titleSize, 0);
        LeftImage.setImageResource(leftimage);
        RightButton.setImageResource(rightback);
        TitleText.setText(title);
        TitleText.setTextColor(textcolor);
        TitleText.setTextSize(textsize);
    }

    public ItemListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
}
