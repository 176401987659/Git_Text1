package com.example.git_text.model;

import com.example.git_text.ApiServer;
import com.example.git_text.base.BaseModel;
import com.example.git_text.base.CallBack;
import com.example.git_text.bean.MeiNvBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public  class MeiNvModel extends BaseModel {
    public void getData(final CallBack<MeiNvBean> meiNvBeanCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServer.Url)
                .build();

        ApiServer apiServer = retrofit.create(ApiServer.class);

        Observable<MeiNvBean> meiNv = apiServer.getMeiNv();

        meiNv.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeiNvBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(MeiNvBean meiNvBean) {
                        meiNvBeanCallBack.onSuccess(meiNvBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        meiNvBeanCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
