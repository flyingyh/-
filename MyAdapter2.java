package com.fhw.bean;

import android.content.Context;

import com.fhw.util.CommonAdpater;
import com.fhw.util.ViewHolder;

import java.util.List;

import circle.fhw.com.friendcircle.R;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public class MyAdapter2 extends CommonAdpater<Bean> {

    public MyAdapter2(Context context, List<Bean> list) {
        super(context,list);
    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder = ViewHolder.get(context,view,viewGroup,R.layout.item_lv,i);
//        Bean bean = list.get(i);
//
//        ((TextView)holder.getView(R.id.tv_title)).setText(bean.getTitle());
//        ((TextView)holder.getView(R.id.tv_desc)).setText(bean.getDesc());
//        ((TextView)holder.getView(R.id.tv_time)).setText(bean.getTime());
//        ((TextView) holder.getView(R.id.tv_phone)).setText(bean.getPhone());
//        return holder.getConvertView();
//    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder holder = ViewHolder.get(context,view,viewGroup,R.layout.item_lv,i);
//        Bean bean = list.get(i);
//
//
//        return holder.getConvertView();
//    }

   /* @Override
    public void convert(ViewHolder holder, Bean bean) {
        ((TextView)holder.getView(R.id.tv_title)).setText(bean.getTitle());
        ((TextView)holder.getView(R.id.tv_desc)).setText(bean.getDesc());
        ((TextView)holder.getView(R.id.tv_time)).setText(bean.getTime());
        ((TextView) holder.getView(R.id.tv_phone)).setText(bean.getPhone());
    }*/

    @Override
    public void convert(ViewHolder holder, Bean bean) {
     holder.setText(R.id.tv_title,bean.getTitle())
         .setText(R.id.tv_desc,bean.getDesc())
         .setText(R.id.tv_time,bean.getTime())
         .setText(R.id.tv_phone,bean.getPhone());
    }


}
