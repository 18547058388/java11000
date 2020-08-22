package com.neusoft.elm.view;

import java.util.Scanner;

public class BusinessMain {

	public static void main(String[] args) {
		while (true) {
			System.out.println("欢迎进入商家首页");
			System.out.println("注册----------1");
			System.out.println("登录----------2");
			System.out.println("结束----------3");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("即将进入注册界面");
				BusinessRegMenu brm = new BusinessRegMenu();
				brm.show();
				break;
			case 2:
				System.out.println("即将进入登录界面");
				BusinessLoginMenu blm=new BusinessLoginMenu();
				blm.show();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("输入错误");
				break;
			}
		}
	}

	}


