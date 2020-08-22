package com.neusoft.elm.dao;

import java.sql.SQLException;

import com.neusoft.elm.po.Admin;

public interface IAdminDao {
public int add(Admin admin) ;
public Admin findByName(String name);
}
