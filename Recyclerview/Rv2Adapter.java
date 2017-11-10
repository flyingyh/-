package com.example.rvdemo.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.rvdemo.MainActivity.*;
import com.example.rvdemo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */

public class Rv2Adapter extends BaseRecyclerAdapter {


    public Rv2Adapter(Context context, List list) {
        super(context, list, R.layout.layout_item);
    }

    @Override
    public void convert(final Context context, BaseRecyclerHolder holder, Object item, int position, boolean isScrolling) {
        Person person = (Person)item;
        holder.setText(R.id.tv,person.getName());
        holder.setOnClickListener(R.id.tv, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
