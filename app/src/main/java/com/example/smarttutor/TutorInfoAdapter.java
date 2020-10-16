package com.example.smarttutor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarttutor.model.TutorInfo;

import java.util.ArrayList;
import java.util.List;

public class TutorInfoAdapter extends RecyclerView.Adapter<ViewAdapter> {

    private List<TutorInfo> tutorInfo = new ArrayList<>();
    Context mContext;
    public TutorInfoAdapter(Context context){
        this.mContext = context;
    }
    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_tutors, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
      holder.name.setText(tutorInfo.get(position).getName());
      holder.subject.setText(tutorInfo.get(position).getSubjects());
      holder.experience.setText(tutorInfo.get(position).getExperience());
      holder.phoneNumber.setText(tutorInfo.get(position).getPhone());
      holder.rating.setText(tutorInfo.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return tutorInfo.size();
    }
    public void setList (List<TutorInfo> list){
        this.tutorInfo = list;
        notifyDataSetChanged();
    }
}
