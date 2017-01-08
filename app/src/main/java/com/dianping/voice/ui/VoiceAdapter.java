package com.dianping.voice.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dianping.voice.R;
import com.dianping.voice.data.Answer;
import com.dianping.voice.data.Question;
import com.dianping.voice.data.Shop;
import com.dianping.voice.widget.AnswerView;
import com.dianping.voice.widget.QuestionView;
import com.dianping.voice.widget.ShopListView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class VoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    public static final int QUESTION_TYPE = 0;
    public static final int ANSWER_TYPE = 1;
    public static final int SHOPLIST_TYPE = 2;

    private final LayoutInflater mLayoutInflater;

    private ArrayList<Object> mVoiceRecord;

    public VoiceAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<Object> voiceRecord){
        mVoiceRecord = voiceRecord;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mVoiceRecord == null)
            return 0;
        android.util.Log.d("wzz","getcount-"+mVoiceRecord.size());
        return mVoiceRecord.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object object = mVoiceRecord.get(position);
        if(object instanceof Question){
            return QUESTION_TYPE;
        }else if(object instanceof Answer){
            return ANSWER_TYPE;
        }else{
            return SHOPLIST_TYPE;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case QUESTION_TYPE:
                return new QuestionHolder(mLayoutInflater.inflate(R.layout.questionview, parent, false));
            case ANSWER_TYPE:
                return new AnswerHolder(mLayoutInflater.inflate(R.layout.answerview, parent, false));
            case SHOPLIST_TYPE:
                return new ShopListHolder(mLayoutInflater.inflate(R.layout.shoplist, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object object = mVoiceRecord.get(position);
        if(holder instanceof QuestionHolder){
            Question question = (Question)object;
            ((QuestionHolder) holder).questionView.setData(question.question);
        }else if(holder instanceof AnswerHolder){
            Answer question = (Answer) object;
            ((AnswerHolder) holder).answerView.setData(question.answer);
        }else if(holder instanceof ShopListHolder){
            ArrayList<Shop> shops = (ArrayList<Shop>)object;
            ((ShopListHolder) holder).shopListView.setData(shops);
        }
    }


    public static class QuestionHolder extends RecyclerView.ViewHolder{

        QuestionView questionView;

        QuestionHolder(View view) {
            super(view);
            questionView = (QuestionView)view.findViewById(R.id.questionview);
        }
    }

    public static class AnswerHolder extends RecyclerView.ViewHolder{

        AnswerView answerView;

        AnswerHolder(View view) {
            super(view);
            answerView = (AnswerView)view.findViewById(R.id.answerview);
        }
    }

    public static class ShopListHolder extends RecyclerView.ViewHolder{

        ShopListView shopListView;

        ShopListHolder(View view) {
            super(view);
            shopListView = (ShopListView)view.findViewById(R.id.shoplistview);
        }
    }
}
