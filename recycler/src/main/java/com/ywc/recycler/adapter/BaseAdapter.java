package com.ywc.recycler.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ywc.recycler.holder.BaseViewHold;
import com.ywc.recycler.mode.LoadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHold>{


    private List<T> listData;
    private int itemLayout;
    private Context context;

    public List<T> getListData() {
        return listData;
    }

    public Context getContext() {

        return context;
    }


    public BaseAdapter(Context context, int itemLayout, List<T> listData) {
        this(context,itemLayout);
        this.listData.addAll(listData);
    }

    public BaseAdapter( Context context,int itemLayout) {
        this(context);
        this.itemLayout = itemLayout;
    }

    public BaseAdapter(Context context)
    {
        this.context = context;
        this.listData=new ArrayList<>();
    }


    public int getHeadCount()
    {
        return 0;
    }

    //默认值是0，head和foot和加载数据 都采用
    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public BaseViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHold(LayoutInflater.from(context).inflate(itemLayout,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHold holder, int position) {
        T t = listData.get(position-getHeadCount());
        onCustomHolder(holder,position-getHeadCount(),t);
        itemListener(holder,position-getHeadCount(),t);
    }

    protected abstract void onCustomHolder(BaseViewHold holder,int position, T t);
    protected void itemListener(BaseViewHold hold,int position,T t)
    {

    }

    //设置动画
    private boolean is_Anima;

    public void flush(List<T> list)
    {
        if (listData.size()>0)
            listData.clear();
        listData.addAll(list);
        notifyDataSetChanged();
    }

    public void flushT(int position)
    {
        if (position>getItemCount())
            notifyItemChanged(position+getHeadCount());
    }

    public void removeT(int position)
    {
        listData.remove(position);
        notifyItemRemoved(position+getHeadCount());
    }

    public void addAll(List<T> list)
    {
        int startPosition = listData.size();
        listData.addAll(list);
        notifyItemRangeChanged(startPosition+getHeadCount(),getItemCount());
    }

    public void addT(T t)
    {
        int startPosition = listData.size();
        listData.add(t);
        notifyItemRangeChanged(startPosition+getHeadCount(),getItemCount());
    }

    public void clear()
    {
        if (listData.size()>0)
        {
            listData.clear();
            notifyDataSetChanged();
        }
    }


    public void flushOrAdd(List<T> list, LoadMode loadMode)
    {
        if (loadMode==LoadMode.PULL_UP)
            addAll(list);
        else
            flush(list);
    }
}
