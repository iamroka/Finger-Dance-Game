package com.example.roka.finomena.views.iview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.roka.finomena.presenter.ipresenter.IPresenter;
import com.example.roka.finomena.util.CodeSnippet;


/**
 * Created by Roka on 1/20/2017.
 */

public interface IView {

    void showMessage(String message);

    void showMessage(int resId);

    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    void showNetworkMessage();

    CodeSnippet getCodeSnippet();

    void bindPresenter(IPresenter iPresenter);


}
