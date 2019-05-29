package com.example.git_text.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected ArrayList<BaseModel> mList = new ArrayList<>();

    protected M myModel;
    protected V myView;

    public void addView(V initMvpView) {
        this.myView = initMvpView;
    }

    public void addModel(M initMvpModel) {
        this.myModel = initMvpModel;
        mList.add(initMvpModel);
    }

    public void destroy() {
        if (myView != null) {
            myView = null;
        }

        if (mList.size() > 0) {
            for (BaseModel baseModel : mList) {
                baseModel.destroy();
            }
        }

        if (myModel != null) {
            myModel = null;
        }
    }
}
