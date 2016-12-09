package com.wallpaper.bingfotor.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
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
import com.victor.loading.rotate.RotateLoading;
import com.wallpaper.bingfotor.BingFotorApplication;
import com.wallpaper.bingfotor.R;
import com.wallpaper.bingfotor.constant.API;
import com.wallpaper.bingfotor.model.entity.Bean;
import com.wallpaper.bingfotor.presenter.IBingPresenter;
import com.wallpaper.bingfotor.presenter.impl.IBingPresenterImpl;
import com.wallpaper.bingfotor.service.NetworkStateService;
import com.wallpaper.bingfotor.utils.DateUtils;
import com.wallpaper.bingfotor.utils.GlideUtils;
import com.wallpaper.bingfotor.utils.HttpUtils;
import com.wallpaper.bingfotor.view.IBingView;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IBingView {
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
    @BindView(R.id.rotateloading)
    RotateLoading rotateLoading;
    private Context context;

    List<String> IMAGES;
    RandomTransitionGenerator generator;
    private boolean isPause=false;
    private IBingPresenter bingPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget() {
        context=MainActivity.this;
        Intent i=new Intent(context,NetworkStateService.class);
        startService(i);
        generator = new RandomTransitionGenerator(5000, new DecelerateInterpolator());
        bing_bg.setTransitionGenerator(generator);
        IMAGES=new ArrayList<>();
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


        bing_bg.setOnClickListener(this);

        bingPresenter=new IBingPresenterImpl(this);
        bingPresenter.getUrlInfo(IMAGES);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bing_bg:
                if (!isPause) {
                    bing_bg.pause();
                    isPause=true;
                }else {
                    bing_bg.resume();
                    isPause=false;
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        bing_bg.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bing_bg.resume();
    }

    @Override
    public void showPic(List<Bean.ImagesBean> posts) {
        GlideUtils.getInstance().loadImage(context,bing_bg,IMAGES.get(0),true);
        title.setText(posts.get(0).getCopyright().substring(0,posts.get(0).getCopyright().indexOf("(")));
        copyright.setText(posts.get(0).getCopyright().substring(posts.get(0).getCopyright().indexOf("("),posts.get(0).getCopyright().indexOf(")")+1));
    }

    @Override
    public void showLoading() {
        rotateLoading.start();
        bing_bg.setClickable(false);
    }

    @Override
    public void hideLoading() {
        rotateLoading.stop();
        bing_bg.setClickable(true);
    }
}
