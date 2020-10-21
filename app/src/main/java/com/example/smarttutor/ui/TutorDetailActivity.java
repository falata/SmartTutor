package com.example.smarttutor.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.smarttutor.R;
import com.example.smarttutor.adapters.TutorPagerAdapter;
import com.example.smarttutor.models.TutorResponse;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;

public class TutorDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private TutorPagerAdapter adapterViewPager;
    List<TutorResponse> mTutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_detail);mTutor = Parcels.unwrap(getIntent().getParcelableExtra("tutors"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new TutorPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTutor);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}