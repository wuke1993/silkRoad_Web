package com.cc.bean;

import java.util.Date;

public class Conference {
	private String title;
	private String url;
	private String onganizer;
	private String start_time;
	private Integer click_times;
	private String res_id;
	private String broad_theme;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOnganizer() {
		return onganizer;
	}
	public void setOnganizer(String onganizer) {
		this.onganizer = onganizer;
	}
	
	
	public Integer getClick_times() {
		return click_times;
	}
	public void setClick_times(Integer click_times) {
		this.click_times = click_times;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String string) {
		this.start_time = string;
	}
	public String getBroad_theme() {
		return broad_theme;
	}
	public void setBroad_theme(String broad_theme) {
		this.broad_theme = broad_theme;
	}
	
}
