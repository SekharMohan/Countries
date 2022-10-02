package com.countries.details.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.countries.details.R;
import com.countries.details.model.Country;
import com.countries.details.network.RemoteCall;

import java.util.List;

public class CountryViewModel extends ViewModel {
    private final RemoteCall mRemoteCall = RemoteCall.getRemoteCallInstance();
    private final MutableLiveData<List<Country>> mCountLivedata = new MutableLiveData<>();

    public void init() {
        mRemoteCall.getCountryList(value ->{
            mCountLivedata.postValue(value);});
    }
    public LiveData<List<Country>> getCountryLiveData() {
        return mCountLivedata;
    }

   public void loadImage() {

   }

}
