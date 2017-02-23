package com.example.roka.finomena.views.fragment;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.roka.finomena.R;
import com.example.roka.finomena.common.Constants;
import com.example.roka.finomena.views.activity.MainActivity;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class InitialSetupFragment extends BaseFragment {
    //private TextView tvTouchCount;
    private EditText etGridSize;
    private int maxCount = 0;

    public InitialSetupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_initial_setup, container, false);
        bindView(rootView);
        ini();
        return rootView;
    }

    private void ini() {
        if (getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND))
            maxCount = 5;
        else if (getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT))
            maxCount = 4;
        else if (getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH))
            maxCount = 2;
        showMessage("Max touch:" + maxCount);
    }

    private void bindView(View rootView) {
        //tvTouchCount = (TextView) rootView.findViewById(R.id.tv_initial_setup_count);
        etGridSize = (EditText) rootView.findViewById(R.id.et_grid_count);

        rootView.findViewById(R.id.tv_initial_setup_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etGridSize.getText()) && Integer.parseInt(etGridSize.getText().toString()) > 1) {
                    ((MainActivity) getActivity()).setGridSize(Integer.parseInt(etGridSize.getText().toString()));
                    ((MainActivity) getActivity()).setMaxCount(maxCount);
                    ((MainActivity) getActivity()).showFragment(Constants.RequestCodes.SHOW_GAME_GRID_FRAGMENT);
                }else
                    showMessage("Enter a number greater than 1");
            }
        });
       /* tvTouchCount.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int count = 0;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        count = count + 1;
                        if (count > maxCount)
                            maxCount = count;
                        tvTouchCount.setText("Max Count=" + maxCount);
                        return false;
                    case MotionEvent.ACTION_UP:
                        count = count - 1;
                        return false;
                    default:
                        return false;
                }
            }
        });*/
    }

}
