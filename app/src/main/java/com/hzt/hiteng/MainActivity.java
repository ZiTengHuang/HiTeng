package com.hzt.hiteng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hzt.hiteng.common.Common;
import com.hzt.hiteng.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {

    @BindView(R.id.mTexttest)
    TextView mText;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mText.setText("哈哈哈哈");
    }
}
