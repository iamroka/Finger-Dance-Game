package com.example.roka.finomena.views.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roka.finomena.R;
import com.example.roka.finomena.adapter.GameGridAdapter;
import com.example.roka.finomena.presenter.GamePresenter;
import com.example.roka.finomena.presenter.ipresenter.IGamePresenter;
import com.example.roka.finomena.views.activity.MainActivity;
import com.example.roka.finomena.views.iview.IGameView;

public class GameFragment extends BaseFragment implements IGameView {
    private RecyclerView vRvGameGrid;
    private IGamePresenter iGamePresenter;
    private GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container,false);
        bindViews(rootView);
        iGamePresenter = new GamePresenter(this);
        iGamePresenter.onCreatePresenter(getArguments());
        iGamePresenter.initiateAdapter(((MainActivity) getActivity()).getGridSize());

        return rootView;
    }

    private void bindViews(View rootView) {
        vRvGameGrid = (RecyclerView) rootView.findViewById(R.id.rv_game_grid);


        gridLayoutManager = new GridLayoutManager(getActivity(), ((MainActivity) getActivity()).getGridSize()){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        vRvGameGrid.setLayoutManager(gridLayoutManager);
        vRvGameGrid.setHasFixedSize(true);
        vRvGameGrid.setNestedScrollingEnabled(false);

    }

    @Override
    public void setGameGridAdapter(GameGridAdapter gameGridAdapter) {
        vRvGameGrid.setAdapter(gameGridAdapter);
    }

    @Override
    public void notifyLoser(boolean isPlayer1) {
        showSnackBar((isPlayer1 ? "Player 1 " : "Player 2 ") + "has lost the game");
        vRvGameGrid.setOnClickListener(null);
        vRvGameGrid.setFocusable(false);
        vRvGameGrid.setEnabled(false);
    }
}
