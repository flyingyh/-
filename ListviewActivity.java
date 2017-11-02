package com.fhw.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.fhw.bean.Bean;
import com.fhw.util.CommonAdpater;
import com.fhw.util.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import circle.fhw.com.friendcircle.R;

public class ListviewActivity extends AppCompatActivity {
    private ListView lv;
    private List<Bean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv = (ListView) findViewById(R.id.lv);

        initData();

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(new Bean("Android 新技能","Android 打造万能的ListView和Grideview适配器","2017-12-12","10086"));
        }
//        MyAdapter2 adapter = new MyAdapter2(this,list);
        lv.setAdapter(new CommonAdpater<Bean>(this,list) {
            private List<Integer> mPos = new ArrayList<Integer>();

            @Override
            public void convert(final ViewHolder holder, final Bean bean) {
                holder.setText(R.id.tv_title,bean.getTitle())
                        .setText(R.id.tv_desc,bean.getDesc())
                        .setText(R.id.tv_time,bean.getTime())
                        .setText(R.id.tv_phone,bean.getPhone());
                final CheckBox cb = holder.getView(R.id.cb);
//                cb.setChecked(bean.isChecke());

                cb.setChecked(false);
                if(mPos.contains(holder.getmPosition())){
                    cb.setChecked(true);
                }
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        bean.setChecke(cb.isChecked());
                        if(cb.isChecked()){
                            mPos.add(holder.getmPosition());
                        }else{
                            mPos.remove((Integer) holder.getmPosition());
                        }

                    }
                });
            }
        });
    }


 /*   public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder =;
        TextView tv = holder.getView(viewId);
        tv.setText();
    }*/
}
