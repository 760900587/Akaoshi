package com.example.akaoshi.model;

import com.example.akaoshi.base.BaseModel;
import com.example.akaoshi.bean.Bean;
import com.example.akaoshi.net.ApiService;
import com.example.akaoshi.net.MainCallBack;
import com.example.akaoshi.presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void getData(MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.Base_url)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<Bean> data = apiService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        mainCallBack.Onsucces(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.OnFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
