package com.hzt.hiteng.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Fragment extends android.support.v4.app.Fragment {

    protected View mRoot;

    //fragment 被调用到 activity时候


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //初始化参数
        initArgs(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //mRoot 做界面复用，如果有就使用没有就赋值下次使用
        //如果不等于空，可能没来得及被回收，就把当前fragment从其父控件移除掉

        if (mRoot == null) {
            int layId = getContentLayoutId();
            View root = inflater.inflate(layId, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    //界面初始化之后
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view 创建完成后初始化数据
        initData();
    }

    protected abstract int getContentLayoutId();

    protected void initWidget(View view) {

    }

    protected void initData() {
    }

    /**
     * 初始化相关参数
     *
     * @param bundle
     * @return 如果参数正确放回true
     */
    protected void initArgs(Bundle bundle) {
    }

    /**
     * 返回按键触发时调用
     * @return  true 代表以处理逻辑 ，activity 不用自己finish
     *  false 代表没处理，activity需要自己走自己逻辑
     */
    public  boolean  onBackPressed(){
            return false;
    }

}
