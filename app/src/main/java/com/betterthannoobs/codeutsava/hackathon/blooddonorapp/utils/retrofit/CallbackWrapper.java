package com.betterthannoobs.codeutsava.hackathon.blooddonorapp.utils.retrofit;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public abstract class CallbackWrapper<T extends BaseResponse> extends DisposableObserver<T> {

    protected abstract void onSuccess(T t);

    @Override
    public void onNext(T t) {
        //You can return StatusCodes of different cases from your API and handle it here. I usually include these cases on BaseResponse and inherit it from every Response
        onSuccess(t);
    }

    @Override
    public final void onError(Throwable e) {
        if (e instanceof HttpException) {
            if (((HttpException) e).code() == 401) {
            }
            //ResponseBody responseBody = ((HttpException) e).response().errorBody();
            //  view.onUnknownError(getErrorMessage(responseBody));
        } else if (e instanceof SocketTimeoutException) {
            // view.onTimeout();
            onErrorNotConsumed(e);
        } else if (e instanceof IOException) {
            // view.onNetworkError();
            onErrorNotConsumed(e);
        } else {
            onErrorNotConsumed(e);
            // view.onUnknownError(e.getMessage());
        }
    }

    public abstract void onErrorNotConsumed(Throwable e);

    @Override
    public void onComplete() {

    }

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}