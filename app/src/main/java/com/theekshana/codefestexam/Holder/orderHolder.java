package com.theekshana.codefestexam.Holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theekshana.codefestexam.R;

public class orderHolder extends RecyclerView.ViewHolder {

    public TextView title, dis, loc, time;
    public ImageView image;
    public String FCMTOken;
    public Button accptBtn;

    public orderHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.newsTitle);
        dis = itemView.findViewById(R.id.newsDis);
        loc = itemView.findViewById(R.id.newLoca);
        time = itemView.findViewById(R.id.newNAme);

    }
}
