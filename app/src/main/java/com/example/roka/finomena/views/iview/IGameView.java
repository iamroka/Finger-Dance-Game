package com.example.roka.finomena.views.iview;

import com.example.roka.finomena.adapter.GameGridAdapter;

/**
 * Created by Roka on 2/20/2017.
 */

public interface IGameView extends IView {
    void setGameGridAdapter(GameGridAdapter gameGridAdapter);

    void notifyLoser(boolean isPlayer1);
}
