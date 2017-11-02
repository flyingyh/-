package com.fhw.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/1 0001.
 */

public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position){
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
        if(convertView == null){
            return  new ViewHolder(context,parent,layoutId,position);
        }else{
           ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return  holder;
        }
    }

    public View getConvertView(){
        return mConvertView;
    }

    /**
     * 通过viewId获取控件
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends  View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return  (T)view;
    }

    /**
     * 设置TextView的值
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText(int viewId,String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置ImageView
     * @param viewId
     * @param resId
     * @return
     */
    public ViewHolder setImageResource(int viewId,int resId){
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

}
