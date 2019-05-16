package com.hzt.hiteng.common.widget.recycler;

public interface AdapterCallback<Data> {
    void updata(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}
