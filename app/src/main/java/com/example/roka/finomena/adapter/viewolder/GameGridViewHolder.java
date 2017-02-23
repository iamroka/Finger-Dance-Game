package com.example.roka.finomena.adapter.viewolder;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.roka.finomena.R;
import com.example.roka.finomena.adapter.listener.GridGameListner;
import com.example.roka.finomena.model.GridItemModel;

/**
 * Created by Roka on 2/20/2017.
 */

public class GameGridViewHolder extends BaseViewHolder<GridItemModel> implements View.OnTouchListener {
    private GridGameListner<GridItemModel> listener;
    private FrameLayout lFlItemLayout;
    private TextView vTvGridText;
    private boolean isPressed = false;

    public GameGridViewHolder(View itemView, GridGameListner<GridItemModel> listener) {
        super(itemView);
        this.listener = listener;
        lFlItemLayout = (FrameLayout) itemView.findViewById(R.id.item_frame);
        vTvGridText = (TextView) itemView.findViewById(R.id.tv_selected_item_text);
        itemView.setOnTouchListener(this);
    }

    @Override
    void populateData(GridItemModel data) {
        vTvGridText.setText(data.getText());
        if (data.getPlayerId() == 1)
            lFlItemLayout.setBackgroundColor(Color.RED);
        else if (data.getPlayerId() == 2)
            lFlItemLayout.setBackgroundColor(Color.BLUE);
     /*   itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickItem(data);
            }
        });*/
        /*itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (!isPressed)
                            listener.onClickItem(data);
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (isPressed)
                            listener.onReleaseItem(data);
                        return true;
                    default:
                        return false;
                }
            }
        });*/
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!isPressed) {
                    isPressed = true;
                    listener.onClickItem(data);
                }
                return true;
            case MotionEvent.ACTION_UP:
                if (isPressed)
                    listener.onReleaseItem(data);
                return true;
            default:
                return false;
        }
    }
}
