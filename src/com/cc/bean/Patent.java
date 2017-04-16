package com.cc.bean;

public class Patent {
	private String id;
	private String patent_number;
	private String title;
	private Integer click_times;
	private String url;
	private String inventor;
	private String assignee_name;
	private String res_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatent_number() {
		return patent_number;
	}
	public void setPatent_number(String patent_number) {
		this.patent_number = patent_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getClick_times() {
		return click_times;
	}
	public void setClick_times(Integer click_times) {
		this.click_times = click_times;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAssignee_name() {
		return assignee_name;
	}
	public void setAssignee_name(String assignee_name) {
		this.assignee_name = assignee_name;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public String getInventor() {
		return inventor;
	}
	public void setInventor(String inventor) {
		this.inventor = inventor;
	}
	
}
