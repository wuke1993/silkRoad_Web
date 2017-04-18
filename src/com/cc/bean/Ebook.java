package com.cc.bean;

public class Ebook {
	private String title;
	private String author;
	private String isbn;
	private String eisbn;
	private String language;
	private String publisher;
	private String year;
	private String pages;
	private Integer click_times;
	private String res_id;
	private String url;
	private String img_url;
	
	public Ebook() {
		
	}
	
	public Ebook(String title, String author, String isbn, String eisbn, String language, String publisher, String year,
			String pages, Integer click_times, String res_id, String url, String img_url) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.eisbn = eisbn;
		this.language = language;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.click_times = click_times;
		this.res_id = res_id;
		this.url = url;
		this.img_url = img_url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setEisbn(String eisbn) {
		this.eisbn = eisbn;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public void setClick_times(Integer click_times) {
		this.click_times = click_times;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getEisbn() {
		return eisbn;
	}

	public String getLanguage() {
		return language;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getYear() {
		return year;
	}

	public String getPages() {
		return pages;
	}

	public Integer getClick_times() {
		return click_times;
	}

	public String getRes_id() {
		return res_id;
	}

	public String getUrl() {
		return url;
	}

	public String getImg_url() {
		return img_url;
	}
	
}
