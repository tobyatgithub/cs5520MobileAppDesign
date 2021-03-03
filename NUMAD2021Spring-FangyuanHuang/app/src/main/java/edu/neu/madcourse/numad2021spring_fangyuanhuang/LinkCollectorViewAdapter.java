package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinkCollectorViewAdapter extends RecyclerView.Adapter<LinkCollectorViewHolder> {
    private final ArrayList<LinkCollectorItemCard> itemList;
    private ItemClickListener listener;

    // Constructor
    public LinkCollectorViewAdapter(ArrayList<LinkCollectorItemCard> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LinkCollectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new LinkCollectorViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkCollectorViewHolder holder, int position) {
        LinkCollectorItemCard currentItem = itemList.get(position);
        holder.itemName.setText(currentItem.getItemName());
        holder.itemURL.setText(currentItem.getItemURL());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
