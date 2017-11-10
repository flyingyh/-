package com.example.rvdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.rvdemo.utils.BaseRecyclerAdapter;
import com.example.rvdemo.utils.Rv2Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Rv2Adapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setName(i+"数据");
            list.add(person);
        }
        adapter2 = new Rv2Adapter(this,list);
        rv.setAdapter(adapter2);


        adapter2.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, final View view, int position) {
                Toast.makeText(MainActivity.this, String.format(Locale.CHINA,"你点击了第%d项,长按会删除！",position),Toast.LENGTH_SHORT).show();
            }
        });

        adapter2.setOnItemLongClickListener(new BaseRecyclerAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(RecyclerView parent, View view, int position) {
                adapter2.delete(position);
                return true;
            }
        });

    }


    public class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
