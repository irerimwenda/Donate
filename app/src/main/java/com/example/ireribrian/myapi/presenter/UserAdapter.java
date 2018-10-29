package com.example.ireribrian.myapi.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ireribrian.myapi.R;
import com.example.ireribrian.myapi.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ireribrian on 10/23/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    List<User> users;

    public UserAdapter(List<User> users){
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {

        holder.firstName.setText(users.get(position).getFirstName());
        holder.lastName.setText(users.get(position).getLastName());
        holder.phoneNumber.setText(users.get(position).getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName;
        private TextView lastName;
        private TextView phoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
        }
    }
}
