package com.example.akaoshi.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> list = new ArrayList<>();

    public void addModel(BaseModel baseModel) {
        list.add(baseModel);
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void bindView(V view) {
        mView = view;
    }

    public void Destory() {
        mView = null;
        for (int i = 0; i < list.size(); i++) {
            list.get(i).Disposable();
        }
    }
}
