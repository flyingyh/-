package com.fhw.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import circle.fhw.com.friendcircle.R;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public abstract  class CommonAdpater<T> extends BaseAdapter {
    protected Context context;
    protected List<T> list;
    protected LayoutInflater inflate;

    public CommonAdpater(Context context, List<T> list) {
        this.context = context;
        this.list = list;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

//    @Override
//    public abstract View getView(int i, View view, ViewGroup viewGroup);

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = ViewHolder.get(context,view,viewGroup, R.layout.item_lv,i);
        convert(holder,getItem(i));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T t);
}
