package com.countries.details;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.countries.details.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentDetailBinding dataBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detail, container, false);
        //dataBinding.setCountry(savedInstanceState.getParcelable("country_key"));
        View view = dataBinding.getRoot();

        return view;
    }
}