package com.example.roka.finomena.views.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;

/**
 * Created by Roka on 1/20/2017.
 */

public class CustomProgressbar extends Dialog {

    private String TAG = getClass().getSimpleName();

    public CustomProgressbar(Context context) throws NullPointerException {
        super(context);
        createProgressBar(context);
    }

    private void createProgressBar(Context context) throws NullPointerException {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getSmallProgressbar(context));
        Window window = getWindow();
        if (window != null) {
            window.setLayout(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawableResource(android.R.color.transparent);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        } else {
            throw new NullPointerException("window not fount exception!");
        }
    }

    private View getSmallProgressbar(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null,
                android.R.attr.progressBarStyleLarge);
        progressBar.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
        return progressBar;
    }

    public void dismissProgress() throws Exception {
        super.dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}