package com.example.git_text.base;

public abstract class BaseMvpActivity<P extends BasePresenter,V extends BaseView,M extends BaseModel> extends BaseActivity {

    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter = initMvpPresenter();
        if(myPresenter !=null){
            myPresenter.addView(initMvpView());
            myPresenter.addModel(initMvpModel());
        }

    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myPresenter !=null){
            myPresenter.destroy();
            myPresenter = null;

        }
    }
}
