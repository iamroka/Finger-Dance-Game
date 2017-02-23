package com.example.roka.finomena.adapter.listener;

/**
 * Created by Roka on 2/23/2017.
 */

public interface GridGameListner<T> {

    void onClickItem(T data);

    void onReleaseItem(T data);
}
