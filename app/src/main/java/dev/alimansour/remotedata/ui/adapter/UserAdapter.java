package dev.alimansour.remotedata.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dev.alimansour.remotedata.R;
import dev.alimansour.remotedata.data.pojo.user.UserResponse;
import dev.alimansour.remotedata.databinding.UsersListItemBinding;

/**
 * RemoteData Android Application developed by: Ali Mansour
 * Copyright © 2021 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- RemoteData IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {
    private List<UserResponse> users;

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UsersListItemBinding binding = UsersListItemBinding.inflate(inflater, parent, false);
        return new UsersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        UserResponse user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setDataSource(List<UserResponse> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        private UsersListItemBinding binding;

        public UsersViewHolder(@NonNull UsersListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(UserResponse user) {
            Context context = binding.getRoot().getContext();
            Glide.with(context).
                    load(context.getString(R.string.image_url))
                    .into(binding.profileImageView);
            binding.idTextView.setText(String.valueOf(user.getId()));
            binding.nameTextView.setText(user.getName());
            binding.userNameTextView.setText(user.getUsername());
            binding.emailTextView.setText(user.getEmail());
            binding.cityTextView.setText(user.getAddress().getCity());
            binding.phoneTextView.setText(user.getPhone());
            binding.websiteTextView.setText(user.getWebsite());
        }
    }
}
