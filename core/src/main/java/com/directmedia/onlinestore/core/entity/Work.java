package com.directmedia.onlinestore.core.entity;

public class Work {
	private String title;
	private String genre;
	private int release;
	private String summary;
	private Artist mainArtist;
	private long id;
	private static long lastId;
	public Work() {
		// TODO Auto-generated constructor stub
		this.id = Work.lastId++;	
	}
	public Work(String title) {
		this();
		this.title = title;
	}
	
	public long getId() {
		return id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRelease() {
		return release;
	}
	public void setRelease(int release) {
		this.release = release;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Artist getMainArtist() {
		return mainArtist;
	}
	public void setMainArtist(Artist mainArtist) {
		this.mainArtist = mainArtist;
	}
	
}
