package com.example.muskangoyal.okhttpgithub;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public classJavaAdapter extends RecyclerView.Adapter <JavaAdapter.MyHolder>{




    ArrayList<GithubUser> githubUsers;


    public JavaAdapter(ArrayList<GithubUser> githubUsers) {
        this.githubUsers = githubUsers;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        GithubUser githubUser = githubUsers.get(position);
        holder.userName.setText(githubUser.getName());
        holder.userUrl.setText(githubUser.getProfileUrl());
        holder.userScore.setText(githubUser.getScore());

    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView userName, userUrl, userScore;
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userLo);
            userUrl = itemView.findViewById(R.id.userurl);
            userScore = itemView.findViewById(R.id.userSc);
            img = itemView.findViewById(R.id.img);
        }
    }
}
