package com.example.roka.finomena.presenter;

import android.content.Intent;

import com.example.roka.finomena.presenter.ipresenter.IPresenter;
import com.example.roka.finomena.views.iview.IView;

/**
 * Created by Roka on 1/20/2017.
 */


public abstract class BasePresenter implements IPresenter {

    protected String TAG = getClass().getSimpleName();

    private IView iView;

    BasePresenter(IView iView) {
        this.iView = iView;
        iView.bindPresenter(this);
    }

    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }
}
