package com.example.mychattest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> mMsgList;
    private LinearLayout left_layout;
    private LinearLayout right_layout;
    private TextView left_msg;
    private TextView right_msg;

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getMsg_type() == Msg.RECEIVE) {
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.right_layout.setVisibility(View.GONE);
            holder.left_msg.setText(msg.getContent());
        } else {
            holder.left_layout.setVisibility(View.GONE);
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.right_msg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout left_layout;
        private LinearLayout right_layout;
        private TextView left_msg;
        private TextView right_msg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            left_layout = itemView.findViewById(R.id.left_layout);
            right_layout = itemView.findViewById(R.id.right_layout);
            left_msg = itemView.findViewById(R.id.left_msg);
            right_msg = itemView.findViewById(R.id.right_msg);
        }
    }
}
