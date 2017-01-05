package com.appbusters.robinpc.delete;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Robin Pc on 12-07-2016.
 */
public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public ItemClickListener clickListener;
    CardView cardview;
    TextView word;
    TextView meaning;
    Bundle bundle;
    Context context;

    View_Holder(View itemView) {
        super(itemView);
        itemView.setTag(itemView); //for RV click
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        context = itemView.getContext();

        cardview = (CardView) itemView.findViewById(R.id.cardview);
        word = (TextView) itemView.findViewById(R.id.word);
        meaning = (TextView) itemView.findViewById(R.id.meaning);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(context, DetailActivity.class);
        context.startActivity(i);
        clickListener.onClick(view, getPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        clickListener.onClick(view, getPosition(), true);
        return true;
    }
}