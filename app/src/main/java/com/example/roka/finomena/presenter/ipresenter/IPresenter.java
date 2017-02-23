package com.example.roka.finomena.presenter.ipresenter;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Roka on 1/20/2017.
 */

public interface IPresenter {

    void onCreatePresenter(Bundle bundle);

    void onStartPresenter();

    void onStopPresenter();

    void onPausePresenter();

    void onResumePresenter();

    void onDestroyPresenter();

    void onActivityResultPresenter(int requestCode, int resultCode, Intent data);
}
