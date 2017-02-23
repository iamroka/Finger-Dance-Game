package com.example.roka.finomena.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.roka.finomena.R;
import com.example.roka.finomena.adapter.listener.BaseRecyclerAdapterListener;
import com.example.roka.finomena.adapter.listener.GridGameListner;
import com.example.roka.finomena.adapter.viewolder.GameGridViewHolder;
import com.example.roka.finomena.model.GridItemModel;

import java.util.List;

/**
 * Created by Roka on 2/20/2017.
 */

public class GameGridAdapter extends BaseRecyclerAdapter<GridItemModel,GameGridViewHolder> {
    private GridGameListner<GridItemModel> listener;
    public GameGridAdapter(List<GridItemModel> data, GridGameListner<GridItemModel> listener) {
        super(data);
        this.listener=listener;
    }

    @Override
    public GameGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameGridViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_game,parent,false),listener);
    }

}
