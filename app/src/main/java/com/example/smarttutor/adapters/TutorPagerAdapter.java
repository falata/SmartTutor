package com.example.smarttutor.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.smarttutor.models.TutorResponse;
import com.example.smarttutor.ui.TutorDetailFragment;

import java.util.List;

public class TutorPagerAdapter  extends FragmentPagerAdapter {
    private List<TutorResponse> mTutors;

    public TutorPagerAdapter(FragmentManager fm, int behavior, List<TutorResponse> tutors) {
        super(fm, behavior);
        mTutors = tutors;
    }

    @Override
    public Fragment getItem(int position) {
        return TutorDetailFragment.newInstance(mTutors.get(position));
    }

    @Override
    public int getCount() {
        return mTutors.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTutors.get(position).getName();
    }

}
