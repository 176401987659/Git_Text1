package com.example.git_text.base;

public abstract class BaseMvpFragment<P extends BasePresenter,V extends BaseView,M extends BaseModel> extends BaseFragment {

    protected P myPresenter;

    @Override
    protected void initMvp() {
        myPresenter = initMvpPresenter();
        if (myPresenter!=null){
            myPresenter.addView(initMvpView());
            myPresenter.addModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (myPresenter!=null){
            myPresenter.destroy();
        }
    }
}
