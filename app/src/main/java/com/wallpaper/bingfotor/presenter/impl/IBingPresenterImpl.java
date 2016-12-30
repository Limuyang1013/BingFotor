package com.wallpaper.bingfotor.presenter.impl;

import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.constant.API;
import com.wallpaper.bingfotor.model.IBingModel;
import com.wallpaper.bingfotor.model.entity.Bean;
import com.wallpaper.bingfotor.model.impl.IBingModelImpl;
import com.wallpaper.bingfotor.presenter.IBingPresenter;
import com.wallpaper.bingfotor.utils.HttpUtils;
import com.wallpaper.bingfotor.view.IBingView;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limuyang on 2016/12/9.
 */

public class IBingPresenterImpl implements IBingPresenter{
    /**
     * 持有View和Model的引用
     */
    private IBingView bingView;
    public IBingPresenterImpl(IBingView bingView){
        this.bingView=bingView;
    }
    @Override
    public void getUrlInfo(final List<String> IMAGES) {
        bingView.showLoading();
        RequestQueue mRequestQueue = Volley.newRequestQueue(BingFotorApplication.getInstance());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(API.PIC_PATH, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JsonArray array = HttpUtils.getResposeJsonObject(response).get("images").getAsJsonArray();
                Type listType = new TypeToken<List<Bean.ImagesBean>>(){}.getType();
                List<Bean.ImagesBean> posts = BingFotorApplication.gsonInstance().fromJson(array.toString(), listType);
                for (int i=0;i<posts.size();i++){
                    IMAGES.add("http://www.bing.com/"+posts.get(i).getUrl());
                }
                bingView.showPic(posts);
                bingView.hideLoading();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                bingView.hideLoading();
                Toast.makeText(BingFotorApplication.getInstance(),"网络出错,请检查网络设置",Toast.LENGTH_SHORT).show();
            }
        });

        mRequestQueue.add(jsonObjectRequest);
    }
}
