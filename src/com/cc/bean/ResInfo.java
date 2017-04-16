package com.cc.bean;

/**
 * Created by Administrator on 2016/11/17.
 */
public class ResInfo {
    private String user_id;
    private String res_id;
    private int times;
    private String res_type;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }


    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getRes_type() {
        return res_type;
    }

    public void setRes_type(String res_type) {
        this.res_type = res_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "ResInfo{" +
                " title='" + title + '\'' +
                ",user_id='" + user_id + '\'' +
                ", res_id='" + res_id + '\'' +
                ", times=" + times +
                ", res_type='" + res_type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
