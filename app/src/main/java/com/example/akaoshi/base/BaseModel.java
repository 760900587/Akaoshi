package com.example.akaoshi.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    private CompositeDisposable compositeDisposable;
    public void addDisposable(Disposable disposable){
        if (compositeDisposable==null){
            synchronized (this){
                if (compositeDisposable==null){
                    compositeDisposable=new CompositeDisposable();
                }
            }
        }
        compositeDisposable.add(disposable);
    }
    public void Disposable(){
        compositeDisposable.dispose();
    }
    public  void rovmeDisposable(Disposable disposable){
        compositeDisposable.remove(disposable);
    }
}
