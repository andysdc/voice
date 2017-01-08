package com.dianping.voice.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dianping.voice.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class ShopView extends RelativeLayout {

    private SimpleDraweeView mImageView;

    private TextView mNameView, mDistanceView, mPriceView;

    private PowerView mPowerView;


    public ShopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.shop_layout, this, true);
        mImageView = (SimpleDraweeView) v.findViewById(R.id.fresco_img);
        mNameView = (TextView)v.findViewById(R.id.shop_name);
//        mDistanceView = (TextView)v.findViewById(R.id.dis_view);
//        mPriceView = (TextView)v.findViewById(R.id.price_view);
//        mPowerView = (PowerView)v.findViewById(R.id.power_view);
    }


    public void setData(String name, String dist, String price, String picUrl, int power){
        if (picUrl.startsWith("http")) {
            mImageView.setImageURI(Uri.parse(picUrl));
        } else {
            mImageView.setImageURI(picUrl);
        }

        mNameView.setText(name);
//        mDistanceView.setText(dist);
//        mPriceView.setText(price);
//        mPowerView.setPower(power);
    }

}
