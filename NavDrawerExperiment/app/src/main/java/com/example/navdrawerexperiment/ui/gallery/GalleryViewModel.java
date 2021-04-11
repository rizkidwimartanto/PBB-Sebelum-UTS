package com.example.navdrawerexperiment.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nama");
        mText.setValue("Alamat");
    }

    public LiveData<String> getText() {
        return mText;
    }
}