package com.brioal.countdowner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.support.v4.widget.Space;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Brioal on 2017/7/4.
 * Email : brioal@foxmail.com
 * Github : https://github.com/Brioal
 */

public class TimeCounter extends LinearLayout {
    private Context mContext;

    //Views
    private Space mSpace;
    private TextView mTvLabelLeft; //剩余时间的标签
    private TextView mTvLabelDay; //天数的标签
    private TextView mTvLabelHour; //小时的标签
    private TextView mTvLabelMinutes; //分钟的标签
    private TextView mTvLabelSeconds; //秒钟的标签

    private TextView mTvNumDay; //天数显示
    private TextView mTvNumHour; //小时显示
    private TextView mTvNumMinutes; //分钟显示
    private TextView mTvNumSeconds; //秒数显示

    private int mTimeLeft = 10 * 24 * 60 * 60 + 10 * 60 * 60 + 10 * 60 + 10; //剩余的毫秒数
    private int mBgColor = Color.parseColor("#D89938");//背景颜色
    private int mTextSize = 6;//文字大小
    private int mLabelTextColor = Color.BLACK;//标签文字颜色
    private int mNumTextColor = Color.WHITE;//文字颜色

    private int mNumDay = 0;//剩余天数
    private int mNumHour = 0;//剩余小时数
    private int mNumMinutes = 0;//剩余分钟数
    private int mNumSeconds = 0;//剩余秒数

    private boolean isShowDay = true;//是否显示天数
    private boolean isShowHour = true;//是否显示小时数
    private boolean isShowMinute = true;//是否显示分数
    private boolean isShowSecond = true;//是否显示秒数


    public TimeCounter(Context context) {
        this(context, null);
    }

    public boolean isShowDay() {
        return isShowDay;
    }

    public TimeCounter setShowDay(boolean showDay) {
        isShowDay = showDay;
        return this;
    }

    public boolean isShowHour() {
        return isShowHour;
    }

    public TimeCounter setShowHour(boolean showHour) {
        isShowHour = showHour;
        return this;
    }

    public boolean isShowMinute() {
        return isShowMinute;
    }

    public TimeCounter setShowMinute(boolean showMinute) {
        isShowMinute = showMinute;
        return this;
    }

    public boolean isShowSecond() {
        return isShowSecond;
    }

    public TimeCounter setShowSecond(boolean showSecond) {
        isShowSecond = showSecond;
        return this;
    }

    /**
     * 设置背景颜色
     *
     * @param mBgColor
     * @return
     */
    public TimeCounter setmBgColor(int mBgColor) {
        this.mBgColor = mBgColor;
        return this;
    }

    /**
     * 设置剩余时间
     *
     * @param mTimeLeft
     * @return
     */
    public TimeCounter setmTimeLeft(int mTimeLeft) {
        this.mTimeLeft = mTimeLeft;
        return this;
    }

    /**
     * 设置字体大小
     *
     * @param mTextSize
     * @return
     */
    public TimeCounter setmTextSize(int mTextSize) {
        this.mTextSize = mTextSize;
        return this;
    }

    /**
     * 设置标签文字颜色
     *
     * @param mLabelTextColor
     * @return
     */
    public TimeCounter setmLabelTextColor(int mLabelTextColor) {
        this.mLabelTextColor = mLabelTextColor;
        return this;
    }

    /**
     * 设置数字文字颜色
     *
     * @param mNumTextColor
     * @return
     */
    public TimeCounter setmNumTextColor(int mNumTextColor) {
        this.mNumTextColor = mNumTextColor;
        return this;
    }

    /**
     * 返回剩余天数
     *
     * @return
     */
    public int getmNumDay() {
        return mNumDay;
    }

    /**
     * 返回剩余小时数
     *
     * @return
     */
    public int getmNumHour() {
        return mNumHour;
    }

    /**
     * 返回剩余分钟数
     *
     * @return
     */
    public int getmNumMinutes() {
        return mNumMinutes;
    }

    /**
     * 返回剩余分钟数
     *
     * @return
     */
    public int getmNumSeconds() {
        return mNumSeconds;
    }

    public TimeCounter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initValues(attrs);
    }

    private void initValues(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.TimeCounter);
        //获取剩余时间
        mTimeLeft = array.getInteger(R.styleable.TimeCounter_timeLeft, 0);
        //获取文字大小
        mTextSize = array.getInteger(R.styleable.TimeCounter_textSize, 6);
        //获取背景颜色
        mBgColor = array.getColor(R.styleable.TimeCounter_bgColor, Color.parseColor("#D89938"));
        //获取标签文字颜色
        mLabelTextColor = array.getColor(R.styleable.TimeCounter_labelTextColor, Color.BLACK);
        //获取文字颜色
        mNumTextColor = array.getColor(R.styleable.TimeCounter_numTextColor, Color.WHITE);
        array.recycle();
    }

    //加载View到ViewGroup
    public void build() {
        mSpace = new Space(mContext);
        mTvLabelLeft = new TextView(mContext);
        mTvLabelDay = new TextView(mContext);
        mTvLabelHour = new TextView(mContext);
        mTvLabelMinutes = new TextView(mContext);
        mTvLabelSeconds = new TextView(mContext);
        mTvNumDay = new TextView(mContext);
        mTvNumHour = new TextView(mContext);
        mTvNumMinutes = new TextView(mContext);
        mTvNumSeconds = new TextView(mContext);

        //清空所有
        removeAllViews();
        //水平布局
        setOrientation(LinearLayout.HORIZONTAL);
        //居中
        setGravity(Gravity.CENTER);
        //空格
        LayoutParams paramsSpace = new LayoutParams(0, LayoutParams.MATCH_PARENT);
        paramsSpace.weight = 1;
        addView(mSpace, paramsSpace);

        //剩余标签
        LayoutParams paramsLabelLeft = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        paramsLabelLeft.leftMargin = DpToPx(2);
        paramsLabelLeft.rightMargin = DpToPx(2);
        mTvLabelLeft.setGravity(Gravity.CENTER);
        mTvLabelLeft.setText("还剩");
        mTvLabelLeft.setTextColor(mLabelTextColor);
        mTvLabelLeft.setTextSize(SpToPx(mTextSize));
        addView(mTvLabelLeft, paramsLabelLeft);

        //剩余天数
        if (isShowDay) {
            LayoutParams paramsDay = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            paramsDay.leftMargin = DpToPx(2);
            paramsDay.rightMargin = DpToPx(2);
            mTvNumDay.setPadding(DpToPx(3), DpToPx(3), DpToPx(3), DpToPx(3));
            mTvNumDay.setGravity(Gravity.CENTER);
            mTvNumDay.setBackgroundResource(R.drawable.ic_bg_orange);
            mTvNumDay.getBackground().setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            mTvNumDay.setTextColor(mNumTextColor);
            mTvNumDay.setTextSize(SpToPx(mTextSize));
            addView(mTvNumDay, paramsDay);
            //天数标签
            LayoutParams paramsLabelDay = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            paramsLabelDay.leftMargin = DpToPx(2);
            paramsLabelDay.rightMargin = DpToPx(2);
            mTvLabelDay.setGravity(Gravity.CENTER);
            mTvLabelDay.setText("天");
            mTvLabelDay.setTextColor(mLabelTextColor);
            mTvLabelDay.setTextSize(SpToPx(mTextSize));
            addView(mTvLabelDay, paramsLabelDay);
        }
        //剩余小时数
        if (isShowHour) {
            LayoutParams paramsHour = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            paramsHour.leftMargin = DpToPx(2);
            paramsHour.rightMargin = DpToPx(2);
            mTvNumHour.setPadding(DpToPx(3), DpToPx(3), DpToPx(3), DpToPx(3));
            mTvNumHour.setGravity(Gravity.CENTER);
            mTvNumHour.setBackgroundResource(R.drawable.ic_bg_orange);
            mTvNumHour.getBackground().setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            mTvNumHour.setTextColor(mNumTextColor);
            mTvNumHour.setTextSize(SpToPx(mTextSize));
            addView(mTvNumHour, paramsHour);
            //小时标签
            LayoutParams paramsLabelHour = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            paramsLabelHour.leftMargin = DpToPx(2);
            paramsLabelHour.rightMargin = DpToPx(2);
            mTvLabelHour.setGravity(Gravity.CENTER);
            mTvLabelHour.setText("时");
            mTvLabelHour.setTextColor(mLabelTextColor);
            mTvLabelHour.setTextSize(SpToPx(mTextSize));
            addView(mTvLabelHour, paramsLabelHour);
        }
        //剩余分钟
        if (isShowMinute) {
            LayoutParams paramsMinutes = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            paramsMinutes.leftMargin = DpToPx(2);
            paramsMinutes.rightMargin = DpToPx(2);
            mTvNumMinutes.setPadding(DpToPx(3), DpToPx(3), DpToPx(3), DpToPx(3));
            mTvNumMinutes.setGravity(Gravity.CENTER);
            mTvNumMinutes.setBackgroundResource(R.drawable.ic_bg_orange);
            mTvNumMinutes.getBackground().setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            mTvNumMinutes.setTextColor(mNumTextColor);
            mTvNumMinutes.setTextSize(SpToPx(mTextSize));
            addView(mTvNumMinutes, paramsMinutes);
            //分钟标签
            LayoutParams paramsLabelMinutes = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            paramsLabelMinutes.leftMargin = DpToPx(2);
            paramsLabelMinutes.rightMargin = DpToPx(2);
            mTvLabelMinutes.setGravity(Gravity.CENTER);
            mTvLabelMinutes.setText("分");
            mTvLabelMinutes.setTextColor(mLabelTextColor);
            mTvLabelMinutes.setTextSize(SpToPx(mTextSize));
            addView(mTvLabelMinutes, paramsLabelMinutes);
        }
        //剩余秒数
        if (isShowSecond) {
            LayoutParams paramsSeconds = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            paramsSeconds.leftMargin = DpToPx(2);
            paramsSeconds.rightMargin = DpToPx(2);
            mTvNumSeconds.setPadding(DpToPx(3), DpToPx(3), DpToPx(3), DpToPx(3));
            mTvNumSeconds.setGravity(Gravity.CENTER);
            mTvNumSeconds.setBackgroundResource(R.drawable.ic_bg_orange);
            mTvNumSeconds.getBackground().setColorFilter(new PorterDuffColorFilter(mBgColor, PorterDuff.Mode.SRC_IN));
            mTvNumSeconds.setTextColor(mNumTextColor);
            mTvNumSeconds.setTextSize(SpToPx(mTextSize));
            addView(mTvNumSeconds, paramsSeconds);
            //秒数标签
            LayoutParams paramsLabelSeconds = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            paramsLabelSeconds.leftMargin = DpToPx(2);
            paramsLabelSeconds.rightMargin = DpToPx(2);
            mTvLabelSeconds.setGravity(Gravity.CENTER);
            mTvLabelSeconds.setText("秒");
            mTvLabelSeconds.setTextColor(mLabelTextColor);
            mTvLabelSeconds.setTextSize(SpToPx(mTextSize));
            addView(mTvLabelSeconds, paramsLabelSeconds);
        }
        //刷新时间
        refreshTime();
    }

    //刷新时间
    private void refreshTime() {
        if (mTimeLeft < 0 || mTimeLeft == 0) {
            mNumDay = 0;
            mNumHour = 0;
            mNumMinutes = 0;
            mNumSeconds = 0;
        } else {
            //计算时间
            //获取秒数
            int currentTime = mTimeLeft;
            //天数
            if (currentTime >= 24 * 60 * 60) {
                //天数大于1
                mNumDay = (currentTime / (24 * 60 * 60));
                currentTime -= (24 * 60 * 60) * mNumDay;
            } else {
                mNumDay = 0;
            }
            //小时数
            if (currentTime >= 60 * 60) {
                //小时数大于1
                mNumHour = (currentTime / (60 * 60));
                currentTime -= (60 * 60) * mNumHour;
            } else {
                mNumHour = 0;
            }
            //分钟数
            if (currentTime >= 60) {
                //分钟数大于1
                mNumMinutes = (currentTime / 60);
                currentTime -= mNumMinutes * 60;
            } else {
                mNumMinutes = 0;
            }

            if (currentTime >= 0) {
                //秒数大于1
                mNumSeconds = currentTime;
            }
        }
        mTvNumDay.setText(supZero(mNumDay));
        mTvNumHour.setText(supZero(mNumHour));
        mTvNumMinutes.setText(supZero(mNumMinutes));
        mTvNumSeconds.setText(supZero(mNumSeconds));
        postDelayed(new Runnable() {
            @Override
            public void run() {
                mTimeLeft--;
                if (mTimeLeft <= 0) {
                    return;
                }
                refreshTime();
            }
        }, 1000);
    }

    //DP 转Px
    private int DpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, mContext.getResources().getDisplayMetrics());
    }

    //SP 转Px
    private int SpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dp, mContext.getResources().getDisplayMetrics());
    }

    //补全位数
    private String supZero(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return num + "";
    }
}
