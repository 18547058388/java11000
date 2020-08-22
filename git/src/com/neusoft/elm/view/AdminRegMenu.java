package com.neusoft.elm.view;

import java.util.Scanner;

import com.neusoft.elm.dao.AdminDaoImpl;
import com.neusoft.elm.po.Admin;

public class AdminRegMenu {

	public void show() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名");
		String name=sc.next();
		System.out.println("请输入密码");
		String password=sc.next();
		System.out.println("请输入重复密码");
		String repassword=sc.next();
		
		if(!password.equals(repassword)){
			System.out.println("两次输入不一致");
			return;
		}
		Admin admin=new Admin();
		admin.setAdminName(name);
        admin.setPassword(password);
		AdminDaoImpl dao=new AdminDaoImpl();
		int result=dao.add(admin);
		if(result>0){
			System.out.println("注册成功，即将返回首页");
			return;
		}
		
		
		
	}

	

}
