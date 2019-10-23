package com.example.curs3ex_1.presenters;
import com.example.curs3ex_1.MainActivity;
import com.example.curs3ex_1.R;
import com.example.curs3ex_1.models.Model;

public class Presenter {
    private Model mModel;
    private MainActivity view;
    public Presenter(MainActivity view){
        this.mModel = new Model();
        this.view = view;
    }
    private int calcNewModelValue(int modelElementIndex){
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }
    public void buttonClick(int btnIndex){
        int newModelValue;
        switch (btnIndex){
            case R.id.btnCounter1:
                newModelValue = calcNewModelValue(0);
                mModel.setElementValueAtIndex(0, newModelValue);
                view.setButtonText(1, newModelValue);
                break;
            case R.id.btnCounter2:
                newModelValue = calcNewModelValue(1);
                mModel.setElementValueAtIndex(1, newModelValue);
                view.setButtonText(2, newModelValue);
                break;
            case R.id.btnCounter3:
                newModelValue = calcNewModelValue(2);
                mModel.setElementValueAtIndex(2, newModelValue);
                view.setButtonText(3, newModelValue);
                break;
        }
    }
}
