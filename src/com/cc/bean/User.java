package com.cc.bean;

/**
 * Created by Administrator on 2016/11/17.
 */
public class User {
    private String _id;
    private String user_id;
    private Res_type res_type;
    
    
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

	public Res_type getRes_type() {
		return res_type;
	}

	public void setRes_type(Res_type res_type) {
		this.res_type = res_type;
	}

   
}
