package com.example.git_text.presenter;

import com.example.git_text.base.BasePresenter;
import com.example.git_text.base.CallBack;
import com.example.git_text.bean.MeiNvBean;
import com.example.git_text.model.MeiNvModel;
import com.example.git_text.view.MeiNvView;

public class MeiNvPresenter extends BasePresenter<MeiNvView, MeiNvModel> {


    public void getData() {
        myModel.getData(new CallBack<MeiNvBean>() {
            @Override
            public void onSuccess(MeiNvBean meiNvBean) {
                myView.onSuccess(meiNvBean);
            }

            @Override
            public void onFail(String mag) {
                myView.onFail(mag);
            }
        });
    }
}
