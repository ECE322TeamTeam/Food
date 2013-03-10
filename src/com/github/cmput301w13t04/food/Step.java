package com.github.cmput301w13t04.food;

import java.util.ArrayList;

public class Step {

	private String name;
	private String description;
	private ArrayList<Photo> photos;

	public Step(String name, String description) {
		this.name = name;
		this.description = description;
		this.photos = new ArrayList<Photo>();
	}
	
	public Step(String name, String description, ArrayList<Photo> photos) {
		this.name = name;
		this.description = description;
		
		if(photos == null)
			this.photos = new ArrayList<Photo>();
		else
			this.photos = photos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addPhoto(Photo photo) {
		this.photos.add(photo);
	}
	
	public void removePhoto(int index) {
		this.photos.remove(index);
	}

}