package com.qiscus.chat.sample.ui.groupchatcreation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qiscus.chat.sample.R;
import com.qiscus.chat.sample.ui.common.OnItemClickListener;
import com.qiscus.chat.sample.ui.common.SortedRecyclerViewAdapter;

/**
 * Created on : May 17, 2018
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
public class SelectedContactAdapter extends SortedRecyclerViewAdapter<SelectableUser, SelectedContactViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;

    public SelectedContactAdapter(Context context, OnItemClickListener onItemClickListener) {
        super();
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    protected Class<SelectableUser> getItemClass() {
        return SelectableUser.class;
    }

    @Override
    protected int compare(SelectableUser item1, SelectableUser item2) {
        return item1.getUser().getName().compareTo(item2.getUser().getName());
    }

    @NonNull
    @Override
    public SelectedContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SelectedContactViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_selected_contact, parent, false), onItemClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedContactViewHolder holder, int position) {
        holder.bind(getData().get(position));
    }
}

