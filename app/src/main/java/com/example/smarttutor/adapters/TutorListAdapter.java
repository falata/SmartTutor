package com.example.smarttutor.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.smarttutor.R;

import com.example.smarttutor.models.TutorResponse;
import com.example.smarttutor.ui.MainActivity;
import com.example.smarttutor.ui.TutorActivity;
import com.example.smarttutor.ui.TutorDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TutorListAdapter  extends RecyclerView.Adapter<TutorListAdapter.TutorViewHolder>{
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 150;
    private Context mContext;
    private List<TutorResponse> mTutor;

    public TutorListAdapter(Context context, List<TutorResponse> tutors) {
        mContext = context;
        mTutor = tutors;
    }

    @Override
    public TutorListAdapter.TutorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tutor_list_item, parent, false);
        TutorViewHolder viewHolder = new TutorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TutorListAdapter.TutorViewHolder holder, int position) {
        holder.bindTutor(mTutor.get(position));
    }

    @Override
    public int getItemCount() {
        return mTutor.size();
    }

    public class TutorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tutorImageView)ImageView mTutorImageView;
        @BindView(R.id.tutorNameTextView) TextView mNameTextView;
        @BindView(R.id.subjectsTextView) TextView mSubjectsTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public TutorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindTutor(TutorResponse tutor) {
            Picasso.get()
                    .load(tutor.getImageUrl())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mTutorImageView);
            mNameTextView.setText(tutor.getName());
            mSubjectsTextView.setText(tutor.getSubjects());
            mRatingTextView.setText("Rating: " +  tutor.getRating() + "/5");
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TutorDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("tutors", Parcels.wrap(mTutor));
            mContext.startActivity(intent);
        }
    }
}
