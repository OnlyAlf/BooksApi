package com.example.alvar.books;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel{

    private MutableLiveData<List<Book>> mutableLiveData;

    public void init() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            JsonExtractor jsonExtractor = new JsonExtractor(mutableLiveData);
            jsonExtractor.execute();
        }
    }

    public MutableLiveData<List<Book>> getMutableLiveData() {
        return mutableLiveData;
    }

}
