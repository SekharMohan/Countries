package com.countries.details.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.countries.details.databinding.ItemBinding;
import com.countries.details.model.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{
    private List<Country> mCountryList;
    private ItemClick mItemClickListener;

    public CountryAdapter(List<Country> countryList, ItemClick itemClickListener) {
        mCountryList = countryList;
        mItemClickListener = itemClickListener;

    }
    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBinding itemBinding = ItemBinding.inflate(layoutInflater, parent, false);
        return new CountryViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {
        holder.mItemBinding.setCountry(mCountryList.get(position));
        holder.mItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mCountryList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
private ItemBinding mItemBinding;
        public CountryViewHolder(@NonNull ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            mItemBinding = itemBinding;
            mItemBinding.itemView.setOnClickListener(v -> mItemClickListener.onClick(mCountryList.get(getAdapterPosition())));

        }
    }
    public interface ItemClick {
        public void onClick(Country country);
    }
}
