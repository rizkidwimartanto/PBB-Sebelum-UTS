package com.example.materialme;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportsViewHolder>  {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    SportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.img_badminton);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public SportsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SportsViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(SportsViewHolder holder, int position) {
        Sport currentSport = mSportsData.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class SportsViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Context mContext;
        private Sport mCurrentSport;
        private GradientDrawable mGradientDrawable;

        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        SportsViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView)itemView.findViewById(R.id.sportsImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Sport currentSport){
            //Populate the textviews with data
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

            //Get the current sport
            mCurrentSport = currentSport;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentSport.
                    getImageResource()).placeholder(mGradientDrawable).into(mSportsImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Sport.starter(mContext, mCurrentSport.getTitle(),
                    mCurrentSport.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}