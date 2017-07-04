package com.brioal.timecountdowner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brioal.countdowner.CountDownerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Brioal on 2017/7/4.
 * Email : brioal@foxmail.com
 * Github : https://github.com/Brioal
 */

public class TimeCounterAdapter extends RecyclerView.Adapter<TimeCounterAdapter.TimeViewHolder> {
    private List<Integer> mList = new ArrayList<>();
    private Context mContext;

    public TimeCounterAdapter(Context mContext) {
        this.mContext = mContext;
        mList.clear();
        Random random = new Random();
        int maxSeconds = 365 * 24 * 60 * 60;
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
        mList.add(random.nextInt(maxSeconds));
    }



    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_timecount,parent,false));
    }

    @Override
    public void onBindViewHolder(TimeViewHolder holder, int position) {
        holder.countDownerView.setmTimeLeft(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class TimeViewHolder extends RecyclerView.ViewHolder{
        CountDownerView countDownerView;
        public TimeViewHolder(View itemView) {
            super(itemView);
            countDownerView = itemView.findViewById(R.id.item_counter);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String msg = countDownerView.getmNumDay() + ":" + countDownerView.getmNumHour() + ":" + countDownerView.getmNumMinutes() + ":" + countDownerView.getmNumSeconds();
                    Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
