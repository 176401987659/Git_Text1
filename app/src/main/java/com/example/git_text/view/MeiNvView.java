package com.example.git_text.view;

import com.example.git_text.base.BaseView;
import com.example.git_text.bean.MeiNvBean;

public interface MeiNvView extends BaseView {
    void onFail(String mag);

    void onSuccess(MeiNvBean meiNvBean);
}
