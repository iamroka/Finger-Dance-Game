package com.example.roka.finomena.presenter;

import android.os.Bundle;

import com.example.roka.finomena.adapter.GameGridAdapter;
import com.example.roka.finomena.adapter.listener.GridGameListner;
import com.example.roka.finomena.common.Constants;
import com.example.roka.finomena.model.GridItemModel;
import com.example.roka.finomena.presenter.ipresenter.IGamePresenter;
import com.example.roka.finomena.views.iview.IGameView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Roka on 2/20/2017.
 */

public class GamePresenter extends BasePresenter implements IGamePresenter {
    private IGameView iGameView;
    private ArrayList<Integer> clickedVals = new ArrayList<>();
    private int randomItemId;
    private List<GridItemModel> gridItemList = new ArrayList<>();
    private GameGridAdapter adapter;
    private int gridSize;
    private boolean isEnded;
    private int maxCount = 2;
    private int touchCount = 0;
    private GridGameListner<GridItemModel> listener = new GridGameListner<GridItemModel>() {
        private boolean isPlayer1 = true;

        @Override
        public void onClickItem(GridItemModel data) {
            if (!isEnded) {
                touchCount = touchCount + 1;

                if (data.getId() == randomItemId) {
                    isPlayer1 = gridItemList.get(randomItemId).getPlayerId() == 1;
                    clickedVals.add(randomItemId);
                    if (clickedVals.size() < gridSize * gridSize) {
                        randomItemId = generateRandomInt();
                        gridItemList.get(randomItemId).setText("Click");
                        if (isPlayer1)
                            gridItemList.get(randomItemId).setPlayerId(2);
                        else
                            gridItemList.get(randomItemId).setPlayerId(1);
                        adapter.notifyItemChanged(randomItemId);
                        //Toast.makeText(iGameView.getActivity(), "Correct Clicked,now click " + randomItemId, Toast.LENGTH_SHORT).show();
                    }/* else*/
                    //Toast.makeText(iGameView.getActivity(), "End", Toast.LENGTH_SHORT).show();
                } else {
                    iGameView.notifyLoser(isPlayer1);
                    isEnded = true;
                }
                if (touchCount > (maxCount - 1) && !isEnded)
                    iGameView.showSnackBar((isPlayer1 ? "Player1 " : "Player2 ") + " please release a key");
            } else
                iGameView.showSnackBar("Game Has Ended");

        }

        @Override
        public void onReleaseItem(GridItemModel data) {
            if (clickedVals.size() < ((gridSize * gridSize)-1)) {
                if (touchCount > (maxCount - 1) && ((isPlayer1 && data.getPlayerId() == 1) || (!isPlayer1 && data.getPlayerId() == 2)))
                    touchCount = touchCount - 1;
                else {
                    if (!isEnded) {
                        isEnded = true;
                        isPlayer1 = data.getPlayerId() == 1;
                        iGameView.showSnackBar("Game Has Ended");
                        iGameView.notifyLoser(isPlayer1);
                    }
                }
            } else {
                //iGameView.showSnackBar("Game Ended");
                isEnded = true;
            }
        }
    };

    public GamePresenter(IGameView iView) {
        super(iView);
        iGameView = iView;
        /*for (int i = 0; i < 9; i++) {
            gridItemList.add(new GridItemModel(i));
        }*/
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        maxCount = bundle.getInt(Constants.BundleKey.MAX_TOUCH_COUNT);
        /*generateGridAdapter(gridItemList);*/
    }

    private void generateGridAdapter(List<GridItemModel> gridItemList) {
        randomItemId = generateRandomInt();
        gridItemList.get(randomItemId).setText("Click");
        gridItemList.get(randomItemId).setPlayerId(1);
        //Toast.makeText(iGameView.getActivity(), "Click button number " + randomItemId, Toast.LENGTH_SHORT).show();
        adapter = new GameGridAdapter(gridItemList, listener);
        iGameView.setGameGridAdapter(adapter);
    }

    private int generateRandomInt() {
        int k = new Random().nextInt(gridSize * gridSize);
        if (clickedVals.contains(k))
            return generateRandomInt();
        else
            return k;
    }

    @Override
    public void initiateAdapter(int gridSize) {
        this.gridSize = gridSize;
        for (int i = 0; i < gridSize * gridSize; i++) {
            gridItemList.add(new GridItemModel(i));
        }
        generateGridAdapter(gridItemList);
    }
}
