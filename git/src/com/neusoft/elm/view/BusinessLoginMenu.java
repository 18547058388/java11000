package com.neusoft.elm.view;

import java.util.Scanner;

import com.neusoft.elm.dao.AdminDaoImpl;
import com.neusoft.elm.dao.BusinessDaoImpl;
import com.neusoft.elm.dao.IAdminDao;
import com.neusoft.elm.dao.IBusinessDao;
import com.neusoft.elm.po.Admin;
import com.neusoft.elm.po.Business;

public class BusinessLoginMenu {

	public void show() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名");
		String name=sc.next();
		System.out.println("请输入密码");
		String password=sc.next();
		IBusinessDao dao=new BusinessDaoImpl();
		Business Business=dao.findByName(name);
		if(null==Business){
			System.out.println("用户名错误");
		}else{
			if(password.equals(Business.getPassword())){
				BusinessMgrMenu bmm=new BusinessMgrMenu();
				bmm.show();

			}else{
				System.out.println("密码错误");
			}
		
	}

}}
