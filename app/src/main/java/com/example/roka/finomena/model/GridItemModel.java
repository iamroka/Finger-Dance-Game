package com.example.roka.finomena.model;

/**
 * Created by Roka on 2/20/2017.
 */

public class GridItemModel {
    public GridItemModel(int id) {
        this.id = id;
    }

    private int id;
    private String text;
    private int playerId=0;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
