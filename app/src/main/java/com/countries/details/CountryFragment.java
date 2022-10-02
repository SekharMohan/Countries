package com.countries.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.countries.details.view.adapter.CountryAdapter;
import com.countries.details.viewmodel.CountryViewModel;


public class CountryFragment extends Fragment {
    private static final String BUNDLE_KEY ="country_key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CountryViewModel model = new ViewModelProvider(this).get(CountryViewModel.class);
        model.init();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ProgressBar progressBar = view.findViewById(R.id.progress_circular);

        model.getCountryLiveData().observe(getViewLifecycleOwner(), countryList -> {
            CountryAdapter adapter = new CountryAdapter(countryList, country -> {
                Bundle bundle = new Bundle();
                bundle.putParcelable(BUNDLE_KEY,country);
                Navigation.findNavController(view).navigate(R.id.detailFragment, bundle);
            });
            recyclerView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        });
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));



    }
}