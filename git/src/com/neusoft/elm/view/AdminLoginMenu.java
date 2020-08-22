package com.neusoft.elm.view;

import java.util.Scanner;

import com.neusoft.elm.dao.AdminDaoImpl;
import com.neusoft.elm.dao.IAdminDao;
import com.neusoft.elm.po.Admin;

public class AdminLoginMenu {

	public void show() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名");
		String name=sc.next();
		System.out.println("请输入密码");
		String password=sc.next();
		IAdminDao dao=new AdminDaoImpl();
		Admin admin=dao.findByName(name);
		if(null==admin){
			System.out.println("用户名错误");
		}else{
			if(password.equals(admin.getPassword())){
				AdminMgrMenu amm=new AdminMgrMenu();
				amm.show();

			}else{
				System.out.println("密码错误");
			}
		}
		
		
		
		
		
		
		
		
	}

}
