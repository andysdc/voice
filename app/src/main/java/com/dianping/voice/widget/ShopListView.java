package com.dianping.voice.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.dianping.voice.R;
import com.dianping.voice.data.Shop;
import java.util.List;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class ShopListView extends LinearLayout implements AdapterView.OnItemClickListener{


    private HorizontalListView mListView;

    private List<Shop> mShopList;

    public ShopListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.shoplist_layout, this, true);
        mListView = (HorizontalListView)findViewById(R.id.horizontal_list);
        mListView.setAdapter(mStoreAdapter);
        mListView.setOnItemClickListener(this);
    }


    public void setData(List<Shop> shoplist){
        mShopList = shoplist;
        mStoreAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Shop shop = mShopList.get(i);
        Uri uri = Uri.parse(shop.shopUrl);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        getContext().startActivity(it);
    }

    private BaseAdapter mStoreAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (mShopList == null)
                return 0;
            return mShopList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.shopview, null);
                holder = new ViewHolder();
                holder.cont = (ShopView)convertView;
                convertView.setTag(holder);
            }
            holder = (ViewHolder) convertView.getTag();
            Shop shop = mShopList.get(position);
            int power = 0;
            int distance = 0;
            try {
                distance = (int)Double.parseDouble(shop._distance_);
                power = Integer.parseInt(shop.power);
            }catch(Exception e){
            }
            holder.cont.setData(shop.shopname, distance+"", shop.avgprice, shop.picUrl, power);
            return convertView;
        }

        class ViewHolder {
            ShopView cont;
        }
    };

}
