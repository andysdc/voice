package com.dianping.voice.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dianping.voice.R;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class QuestionView extends LinearLayout{

    private TextView mTextView;

    public QuestionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View v = LayoutInflater.from(context).inflate(R.layout.question_layout, this, true);
        mTextView = (TextView)v.findViewById(R.id.question_view);

    }

    public void setData(String str){
        mTextView.setText(str);
    }

}
