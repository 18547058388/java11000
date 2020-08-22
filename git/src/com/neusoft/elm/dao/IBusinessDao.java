package com.neusoft.elm.dao;


import com.neusoft.elm.po.Business;

public interface IBusinessDao {
	public int add(Business Business) ;
	public Business findByName(String name);
}
