package com.wallpaper.bingfotor.view;

import com.wallpaper.bingfotor.model.entity.Bean;

import java.util.List;

/**
 * Created by Limuyang on 2016/12/9.
 */

public interface IBingView {
    void showPic(List<Bean.ImagesBean> posts);
    void showLoading();
    void hideLoading();
}
