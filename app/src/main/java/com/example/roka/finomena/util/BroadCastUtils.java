package com.example.roka.finomena.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.roka.finomena.common.Constants;
/**
 * Created by Roka on 1/20/2017.
 */

public class BroadCastUtils {

    private Context mContext;

    public BroadCastUtils(Context mContext) {
        this.mContext = mContext;
    }

    public void doBroadcast(Bundle result) {
        Intent intent = new Intent(Constants.BundleKey.BROADCAST_MESSAGE);
        intent.putExtras(result);
        mContext.sendBroadcast(intent);
    }
}
