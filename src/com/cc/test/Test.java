package com.cc.test;

import org.bson.types.ObjectId;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "qqqqqqqwwwwd";
		String a =string.substring(0, string.length()-1);
		System.out.println(a);
		ObjectId id = ObjectId.get();
		System.out.println(id.toHexString());
	}

}
