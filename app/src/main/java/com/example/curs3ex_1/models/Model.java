package com.example.curs3ex_1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private List<Integer> mList;
    public Model(){
        mList = new ArrayList<>(3);
        mList.add(0);
        mList.add(0);
        mList.add(0);
    }
    public int getElementValueAtIndex(int _index){
        return mList.get(_index);
    }
    public void setElementValueAtIndex(int _index, int value){
        mList.set(_index, value);
    }

}
