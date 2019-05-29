package com.example.git_text.base;

public interface CallBack<T> {

    void onSuccess(T t);
    void onFail(String mag);
}
