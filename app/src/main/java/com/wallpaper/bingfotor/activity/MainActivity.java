package com.wallpaper.bingfotor.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.google.gson.JsonObject;
import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.R;
import com.wallpaper.bingfotor.constant.API;
import com.wallpaper.bingfotor.model.DataBean;
import com.wallpaper.bingfotor.utils.DateUtils;
import com.wallpaper.bingfotor.utils.GlideUtils;
import com.wallpaper.bingfotor.utils.HttpUtils;

import org.json.JSONObject;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
    }
    public static Handler UIHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

            }
        }
    };

    private void initWidget() {
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
        final String[] response_path = new String[3];
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(API.BING_PIC_PIXCEL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JsonObject jsonObject=HttpUtils.getResposeJsonObject(response).get("data").getAsJsonObject();
                DataBean info= BingFotorApplication.gsonInstance().fromJson(jsonObject,DataBean.class);
                response_path[0] =info.getThumbnail_pic();
                response_path[1]=info.getBmiddle_pic();
                response_path[2]=info.getOriginal_pic();
//                GlideUtils.getInstance().loadOverrideImage(MainActivity.this,bing_bg,info.getOriginal_pic(),screenWidth,screenHeight);
                GlideUtils.getInstance().loadImage(MainActivity.this,bing_bg,"http://www.dujin.org/sys/bing/1920.php",true);
                title.setText(info.getTitle());
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
