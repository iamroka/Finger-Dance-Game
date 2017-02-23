package com.example.roka.finomena.views.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.example.roka.finomena.R;
import com.example.roka.finomena.common.Constants;
import com.example.roka.finomena.views.fragment.BaseFragment;
import com.example.roka.finomena.views.fragment.GameFragment;
import com.example.roka.finomena.views.fragment.InitialSetupFragment;

public class MainActivity extends BaseActivity {
    private FragmentTransaction fragmentTransaction;
    private int gridSize=0;
    private int maxCount;

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(Constants.RequestCodes.SHOW_CALIBRATION_FRAGMENT);
    }

    public void showFragment(int fragmentCode) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        BaseFragment fragment;
        switch (fragmentCode) {
            case Constants.RequestCodes.SHOW_CALIBRATION_FRAGMENT:
                fragment = new InitialSetupFragment();
                fragmentTransaction.add(R.id.activity_main, fragment);
                break;
            case Constants.RequestCodes.SHOW_GAME_GRID_FRAGMENT:
                fragment = new GameFragment();
                Bundle bundle= new Bundle();
                bundle.putInt(Constants.BundleKey.MAX_TOUCH_COUNT,maxCount);
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.activity_main, fragment);
                break;
            default:
                fragment = new InitialSetupFragment();
                fragmentTransaction.add(R.id.activity_main, fragment);
                break;
        }


        fragmentTransaction.addToBackStack(String.valueOf(fragmentCode));
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1)
            getSupportFragmentManager().popBackStack();
            //showFragment(Constants.RequestCodes.SHOW_CALIBRATION_FRAGMENT);
        else finish();
       /* super.onBackPressed();*/
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
}
