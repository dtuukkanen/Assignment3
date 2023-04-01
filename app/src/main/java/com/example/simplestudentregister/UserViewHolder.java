package com.example.simplestudentregister;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name, degreeProgram, email, degrees;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textName);
        degreeProgram = itemView.findViewById(R.id.textDegreeProgram);
        email = itemView.findViewById(R.id.textEmailAddress);
        degrees = itemView.findViewById(R.id.textDegrees);
    }
}
