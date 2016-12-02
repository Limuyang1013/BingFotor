package com.wallpaper.bingfotor.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.R;
import com.wallpaper.bingfotor.constant.API;
import com.wallpaper.bingfotor.model.Bean;
import com.wallpaper.bingfotor.utils.DateUtils;
import com.wallpaper.bingfotor.utils.HttpUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Typeface TEXT_TYPE ;
    @BindView(R.id.bing_bg)
    ImageView bing_bg;
    @BindView(R.id.day)
    TextView day;
    @BindView(R.id.month)
    TextView month;
    @BindView(R.id.week)
    TextView week;
    @BindView(R.id.title)
    TextView title;
    private Context context;

    List<String> IMAGES;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget() {
        context=MainActivity.this;
        IMAGES=new ArrayList<>();
        getUrlInfo();
        // 加载自定义字体
        try{
            TEXT_TYPE = Typeface.createFromAsset(getAssets(),"HelveticaNeueLTPro-ThEx.otf");
        }catch(Exception e){
            Log.i("MainActivity","加载第三方字体失败。") ;
            TEXT_TYPE = null ;
        }
        if (TEXT_TYPE!=null){
            month.setTypeface(TEXT_TYPE);
            week.setTypeface(TEXT_TYPE);
            day.setTypeface(TEXT_TYPE);
            title.setTypeface(TEXT_TYPE);
            month.setText(DateUtils.covertMonth(DateUtils.month()));
            week.setText(DateUtils.convertWeek(DateUtils.week()));
            day.setText(DateUtils.day()+"");
        }



    }

    private void getUrlInfo() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(API.BING_PIC_PIXCEL, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                JsonObject jsonObject=HttpUtils.getResposeJsonObject(response).get("data").getAsJsonObject();
//                DataBean info= BingFotorApplication.gsonInstance().fromJson(jsonObject,DataBean.class);
//                title.setText(info.getTitle());
//                Glide.with(context)
//                        .load("http://s.cn.bing.net/az/hprichbg/rb/ResurrectionBay_ZH-CN10718475653_1920x1080.jpg")
//                        .centerCrop()
//                        .override(ScreenUtils.getScreenWidth(context), (int) (ScreenUtils.getScreenWidth(context)*1.2))
//                        .into(bing_bg);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(),"网络出错,请检查网络设置",Toast.LENGTH_SHORT).show();
//            }
//        });
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(API.PIC_PATH, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JsonArray array = HttpUtils.getResposeJsonObject(response).get("images").getAsJsonArray();
                Type listType = new TypeToken<List<Bean.ImagesBean>>(){}.getType();
                List<Bean.ImagesBean> posts = BingFotorApplication.gsonInstance().fromJson(array.toString(), listType);
                for (int i=0;i<posts.size();i++){
                    IMAGES.add(posts.get(i).getUrl());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"网络出错,请检查网络设置",Toast.LENGTH_SHORT).show();
            }
        });

        mRequestQueue.add(jsonObjectRequest);
    }



}
