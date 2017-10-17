package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;

public class VideoGame {
	private String name;
	private double price;
	private double rating;
	private ArrayList<String> genres = new ArrayList<String>();
	
	public VideoGame(String name, double price, double rating, String[] stringArray){
		this.name = name.toLowerCase();
		this.price = price;
		this.rating = rating;
		for(int i = 0; i < stringArray.length; i++){
			genres.add(stringArray[i].toLowerCase());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}

	public void setGenres(String[] stringArray) {
		genres.clear();
		for(int i = 0; i < stringArray.length; i++){
			genres.add(stringArray[i].toLowerCase());
		}
	}
	
	
}
