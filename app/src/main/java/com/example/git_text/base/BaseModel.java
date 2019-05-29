package com.example.git_text.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseModel {

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    public void destroy() {
        mCompositeDisposable.clear();
    }
}
