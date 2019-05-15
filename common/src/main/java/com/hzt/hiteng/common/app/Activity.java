package com.hzt.hiteng.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在窗口未初始化之前调用初始化数据
        initWindows();

        //根据Activity Intent Activity 特效，没到一个activity都会bundle来实现通信，如果获取不到
        if (initArgs(getIntent().getExtras())) {
            getContentLayoutId();
            initWidget();
            initDate();
        } else {

            finish();
        }
    }

    /**
     * 初始化窗口
     */
    protected void initWindows() {

    }

    /**
     * 初始化相关参数
     *
     * @param bundle
     * @return 如果参数正确放回true
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 初始化控件
     */
    protected void initWidget() {
    }

    /**
     * 得到当前界面的资源文件ID
     *
     * @return layoutId
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化数据
     */
    protected void initDate() {

    }

    /**
     * 点击导航返回界面 finish当前界面
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    /**
     * 安卓硬件按钮返回，虽然说也是要放回，但是有一个情况
     * 一个Activity 有多个fragment 多个层次
     * 想返回上个fragment ,封装下fragment 和activity进行通信
     */
    @Override
    public void onBackPressed() {
        //获取所有的fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();

        if (fragments!=null && fragments.size()>0){
            for (Fragment fragment :fragments){
                //判断是否为自己的Fragment ，是的话可以处理
                 if (fragment instanceof com.hzt.hiteng.common.app.Fragment){
                     //判断是否拦截了返回按钮
                     if (((com.hzt.hiteng.common.app.Fragment)fragment).onBackPressed()){
                         return;
                     }
                 }
            }
        }
        super.onBackPressed();
        finish();
    }
}
