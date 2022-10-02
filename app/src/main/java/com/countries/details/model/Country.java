package com.countries.details.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class Country implements Parcelable {
	private List<String> capital;
	private Languages languages;
	private Maps maps;
	private String subregion;
	private Name name;
	private Flags flags;
	private String region;
	private List<String> continents;
	private int population;

	protected Country(Parcel in) {
		capital = in.createStringArrayList();
		subregion = in.readString();
		region = in.readString();
		continents = in.createStringArrayList();
		population = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(capital);
		dest.writeString(subregion);
		dest.writeString(region);
		dest.writeStringList(continents);
		dest.writeInt(population);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Country> CREATOR = new Creator<Country>() {
		@Override
		public Country createFromParcel(Parcel in) {
			return new Country(in);
		}

		@Override
		public Country[] newArray(int size) {
			return new Country[size];
		}
	};

	public List<String> getCapital(){
		return capital;
	}

	public Languages getLanguages(){
		return languages;
	}

	public Maps getMaps(){
		return maps;
	}

	public String getSubregion(){
		return subregion;
	}

	public Name getName(){
		return name;
	}

	public Flags getFlags(){
		return flags;
	}

	public String getRegion(){
		return region;
	}

	public List<String> getContinents(){
		return continents;
	}

	public int getPopulation(){
		return population;
	}

	@BindingAdapter("android:loadImage")
	public static void loadImage(ImageView imageView, String imageUrl) {
		Glide.with(imageView.getContext())
				.load(imageUrl)
				.into(imageView);
	}
}