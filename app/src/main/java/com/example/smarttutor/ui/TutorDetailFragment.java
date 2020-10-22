package com.example.smarttutor.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarttutor.R;
import com.example.smarttutor.models.TutorResponse;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TutorDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorDetailFragment extends Fragment {

    @BindView(R.id.tutorImageView) ImageView mImageLabel;
    @BindView(R.id.tutorNameTextView) TextView mNameLabel;
    @BindView(R.id.subjectsTextView) TextView mSubjectsLabel;
    @BindView(R.id.ratingTextView) TextView mRatingLabel;
    @BindView(R.id.experienceTextView) TextView mExperienceLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id. bioTextView) TextView mBioLabel;


    private TutorResponse mTutor;

    public TutorDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment TutorDetailFragment.
     */
    public static TutorDetailFragment newInstance(TutorResponse tutor) {
        TutorDetailFragment tutorDetailFragment = new TutorDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("tutor", Parcels.wrap(tutor));
        tutorDetailFragment.setArguments(args);
        return tutorDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTutor = Parcels.unwrap(getArguments().getParcelable("tutor"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutor_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mTutor.getImageUrl()).into(mImageLabel);
        mNameLabel.setText(mTutor.getName());
        mSubjectsLabel.setText(mTutor.getSubjects());
        mRatingLabel.setText(Double.toString(mTutor.getRating()) + "/5");
        mPhoneLabel.setText(mTutor.getPhone());
        mExperienceLabel.setText(mTutor.getExperience());
        mBioLabel.setText(mTutor.getBio());
        return view;
    }

}