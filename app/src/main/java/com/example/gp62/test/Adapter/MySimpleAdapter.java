package com.example.gp62.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import java.util.Map;

public class MySimpleAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> data;//数据源
    private int res_layout;//布局文件对应的ID
    private String[] form;//索引
    private int[] to;//对应组件ID
    private LayoutInflater inflater;//用于动态载入界面的inflater

    public MySimpleAdapter(Context context,List<Map<String,Object>> data,int res_layout,String[] form,int[] to){
        this.context=context;
        this.data=data;
        this.res_layout=res_layout;
        this.form=form;
        this.to=to;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount(){
        return data.size();
    }
    @Override
    public Object getItem(int position){
        return  data.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int p, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(res_layout,null);
        return convertView;
    }
}
