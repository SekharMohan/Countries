package com.countries.details.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.countries.details.R;
import com.countries.details.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentDetailBinding dataBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detail, container, false);
        if(getArguments().getParcelable("country_key")!=null) {
        dataBinding.setCountry(getArguments().getParcelable("country_key"));
        }
        View view = dataBinding.getRoot();

        return view;
    }
    public void onSearchClick(View v){
        Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
    }

}