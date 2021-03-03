package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinkCollectorViewHolder extends RecyclerView.ViewHolder {
    public TextView itemName;
    public TextView itemURL;


    public LinkCollectorViewHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        itemName = itemView.findViewById(R.id.item_name);
        itemURL = itemView.findViewById(R.id.item_url);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
