package com.example.curs3ex_1.presenters;
import android.support.annotation.NonNull;
import com.example.curs3ex_1.MainView;
import com.example.curs3ex_1.models.Model;

import java.lang.ref.WeakReference;

public class Presenter {
    private Model mModel;
    private WeakReference<MainView> view;
    private static Presenter instance;

    public static Presenter getInstance() {
        if (instance == null) {
            instance = new Presenter();
        }
        return instance;
    }
    public Presenter(){
        this.mModel = new Model();
    }

    private int calcNewModelValue(int modelElementIndex){
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }
    public void buttonClick(int btnIndex){
        int newModelValue;
        newModelValue = calcNewModelValue(btnIndex);
        mModel.setElementValueAtIndex(btnIndex, newModelValue);
        view().setButtonText(btnIndex, newModelValue);
    }

    protected boolean setupDone() {
        return view() != null && mModel != null;
    }

    protected MainView view() {
        if (view == null) {
            return null;
        } else {
            return view.get();
        }
    }

    public void bindView(@NonNull MainView view) {
        this.view = new WeakReference<>(view);
        if (setupDone()) {
            updateView();
        }
    }

    public void unbindView() {
        this.view = null;
    }

    protected void updateView() {
        for (int i=0; i<3; i++){
            int value = mModel.getElementValueAtIndex(i);
            view().setButtonText(i, value);
        }
    }


}
