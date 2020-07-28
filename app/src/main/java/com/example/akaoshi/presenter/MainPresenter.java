package com.example.akaoshi.presenter;

import com.example.akaoshi.View.MainView;
import com.example.akaoshi.base.BaseFragment;
import com.example.akaoshi.base.BasePresenter;
import com.example.akaoshi.bean.Bean;
import com.example.akaoshi.model.MainModel;
import com.example.akaoshi.net.MainCallBack;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBack {
    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void Onsucces(Bean bean) {
        mView.setData(bean);
    }

    @Override
    public void OnFail(String string) {
        mView.ShowTosat(string);
    }
}
