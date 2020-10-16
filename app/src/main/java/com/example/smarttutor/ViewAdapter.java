package com.example.smarttutor;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAdapter extends RecyclerView.ViewHolder {
    TextView name, subject, experience ,phoneNumber, rating;
    public ViewAdapter(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        subject = itemView.findViewById(R.id.subbject);
        experience = itemView.findViewById(R.id.experience);
        phoneNumber = itemView.findViewById(R.id.phone_number);
        rating = itemView.findViewById(R.id.rating);

    }
}
