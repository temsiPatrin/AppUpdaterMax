package com.temsi.appupdater.interfaces;

public interface IProgressListener {
    void onStartAction();
    void FinishActionFailed();
    void FinishActionSuccess();
}
