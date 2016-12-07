package com.wallpaper.bingfotor.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.R;
import com.wallpaper.bingfotor.constant.API;
import com.wallpaper.bingfotor.model.Bean;
import com.wallpaper.bingfotor.utils.DateUtils;
import com.wallpaper.bingfotor.utils.GlideUtils;
import com.wallpaper.bingfotor.utils.HttpUtils;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {
    private Typeface TEXT_TYPE ;
    @BindView(R.id.bing_bg)
    KenBurnsView bing_bg;
    @BindView(R.id.day)
    TextView day;
    @BindView(R.id.month)
    TextView month;
    @BindView(R.id.week)
    TextView week;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.copyright)
    TextView copyright;
    private Context context;

    List<String> IMAGES;
    RandomTransitionGenerator generator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget() {
        context=MainActivity.this;
        generator = new RandomTransitionGenerator(5000, new DecelerateInterpolator());
        bing_bg.setTransitionGenerator(generator);
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

        bing_bg.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {

            }
        });

    }

    private void getUrlInfo() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(API.PIC_PATH, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JsonArray array = HttpUtils.getResposeJsonObject(response).get("images").getAsJsonArray();
                Type listType = new TypeToken<List<Bean.ImagesBean>>(){}.getType();
                List<Bean.ImagesBean> posts = BingFotorApplication.gsonInstance().fromJson(array.toString(), listType);
                for (int i=0;i<posts.size();i++){
                    IMAGES.add(posts.get(i).getUrl());
                }
                GlideUtils.getInstance().loadImage(context,bing_bg,IMAGES.get(0),true);
                title.setText(posts.get(0).getCopyright().substring(0,posts.get(0).getCopyright().indexOf("(")));
                copyright.setText(posts.get(0).getCopyright().substring(posts.get(0).getCopyright().indexOf("("),posts.get(0).getCopyright().indexOf(")")+1));
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
