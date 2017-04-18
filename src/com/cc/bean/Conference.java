package com.cc.bean;

public class Conference {
	private String title;
	private String url;
	private String organizer;
	private String start_time;
	private Integer click_times;
	private String res_id;
	private String broad_theme;
	
	public Conference() {
		
	}
	
	public Conference(String title, String url, String organizer, String start_time, 
			Integer click_times, String res_id, String broad_theme) {
		this.title = title;
		this.url = url;
		this.organizer = organizer;
		this.start_time = start_time;
		this.click_times = click_times;
		this.res_id = res_id;
		this.broad_theme = broad_theme;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public void setClick_times(Integer click_times) {
		this.click_times = click_times;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public void setBroad_theme(String broad_theme) {
		this.broad_theme = broad_theme;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getOrganizer() {
		return organizer;
	}

	public String getStart_time() {
		return start_time;
	}

	public Integer getClick_times() {
		return click_times;
	}

	public String getRes_id() {
		return res_id;
	}

	public String getBroad_theme() {
		return broad_theme;
	}
	
}
