package com.wallpaper.bingfotor.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wallpaper.bingfotor.R;
import com.wallpaper.bingfotor.utils.StringUtils;

/**
 * Created by Limuyang on 2017/2/15.
 */

public class PromptDialog {
    //点击确认按钮回调
    public interface OnConfirmListener{
        void onConfirmClick();
    }

    public static void show(Activity activity, String content, final OnConfirmListener onConfirmListener){
        //加载布局
        View view = View.inflate(activity, R.layout.dialog_layout,null);
        TextView text = (TextView) view.findViewById(R.id.text);
        TextView confirm = (TextView) view.findViewById(R.id.confirm);
        TextView cancle = (TextView) view.findViewById(R.id.cancel);

        if (!StringUtils.isNullOrEmpty(content)){
            text.setText(content);
        }

        final AlertDialog dialog=new AlertDialog.Builder(activity).create();
        dialog.setCancelable(false);
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(StringUtils.getWidth(activity)*3/4, ViewGroup.LayoutParams.WRAP_CONTENT);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onConfirmListener.onConfirmClick();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
