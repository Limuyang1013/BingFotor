package com.wallpaper.bingfotor.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.model.entity.Bean;
import com.wallpaper.bingfotor.presenter.IBingPresenter;
import com.wallpaper.bingfotor.presenter.impl.IBingPresenterImpl;
import com.wallpaper.bingfotor.utils.GlideUtils;
import com.wallpaper.bingfotor.view.IBingView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limuyang on 2016/12/7.
 */

public class NetworkStateService extends Service{

    private static final String tag="tag";
    private ConnectivityManager connectivityManager;
    private NetworkInfo info;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                Log.d(tag, "网络状态已经改变");
                connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                info = connectivityManager.getActiveNetworkInfo();
                if(info != null && info.isAvailable()) {
                    Toast.makeText(BingFotorApplication.getInstance(),"网络良好",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BingFotorApplication.getInstance(),"没有可用网络",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, mFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


}
