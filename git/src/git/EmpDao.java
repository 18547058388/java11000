package com.neuedu.jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	public List<Emp> findAll() {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Emp> empList=new ArrayList();//1、empList在循环外定义    大的容器，接住所有查询出来的对象
		// 1）载入jdbc驱动(指定我要连接到哪种数据库，连接不同数据库用不同驱动)
		try {
		Class.forName("com.mysql.jdbc.Driver");
		// java.sql.DriverManager.registerDriver(new Driver());
		// 2）定义连接url(连接准备 url,端口，用户名，密码)
		// jdbc:mysql://ip:port/databasename?characterEncoding=UTF-8&useUnicode=true
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user = "root";
		String password = "root";
		// 3）建立连接
		conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		// 4）创建PreparedStatement（动态） Statement(静态的)(拼sql语句)
		ps = conn.prepareStatement("select * from emp ");
		// 5）执行数据库命令（crud)
		// 注意的点
		// ps.executeUpdate() 用于insert update delete
		// 用于select
		rs = ps.executeQuery();
		// 6）结果集的处理（查询有，添加修改删除没有）
		// rs.next() iterator hasnext()+next()
		
		while (rs.next()) {
		    //对象在循环里定义
			Emp emp=new Emp();
			//每读取一条记录，就创建一个对象
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setComm(rs.getInt("comm"));//有可能会异常
			emp.setDeptno(rs.getInt("deptno"));
			emp.setHiredate(rs.getString("hiredate"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setSal(rs.getInt("sal"));
			empList.add(emp);
		}
		System.out.println(empList);
		
		} catch (ClassNotFoundException e) {
			System.out.println("驱动错误");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("操作数据库错误");
			e.printStackTrace();
		}finally{
			// 7）关闭连接
			try {
				if(rs!=null){
				rs.close();
				}
				if(ps!=null){
				ps.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				System.out.println("关闭数据库异常");
				e.printStackTrace();
			}
			
		}
		return empList;
		
		
	}
	public Emp findById(int id) throws SQLException, ClassNotFoundException {
		// 1）载入jdbc驱动(指定我要连接到哪种数据库，连接不同数据库用不同驱动)
		Class.forName("com.mysql.jdbc.Driver");
		// java.sql.DriverManager.registerDriver(new Driver());
		// 2）定义连接url(连接准备 url,端口，用户名，密码)
		// jdbc:mysql://ip:port/databasename?characterEncoding=UTF-8&useUnicode=true
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user = "root";
		String password = "root";
		// 3）建立连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		// 4）创建PreparedStatement（动态） Statement(静态的)(拼sql语句)
		PreparedStatement ps = conn.prepareStatement("select * from emp where empno=?");
		ps.setInt(1, id);
		
		// 5）执行数据库命令（crud)
		// 注意的点
		// ps.executeUpdate() 用于insert update delete
		// 用于select
		ResultSet rs = ps.executeQuery();
		// 6）结果集的处理（查询有，添加修改删除没有）
		// rs.next() iterator hasnext()+next()
		Emp emp=null;//单条时，只需要返回一个emp对象即可
		if (rs.next()) {
		    //对象在循环里定义
			emp=new Emp();
			//每读取一条记录，就创建一个对象
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setComm(rs.getInt("comm"));//有可能会异常
			emp.setDeptno(rs.getInt("deptno"));
			emp.setHiredate(rs.getString("hiredate"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setSal(rs.getInt("sal"));
			
		}
		System.out.println(emp.getEname());
		// 7）关闭连接
		rs.close();
		ps.close();
		conn.close();
		return emp;
	}
	//思考传什么好
	public int insert() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		PreparedStatement ps=conn.prepareStatement("insert into emp values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, 8003);
		ps.setString(2, "冯广锐");
		ps.setString(3, "ANALYST");
		ps.setInt(4, 7698);
		ps.setString(5, "2020-09-28");
		ps.setInt(6, 20000);
		ps.setInt(7, 200);
		ps.setInt(8, 20);
		int result=ps.executeUpdate();
		System.out.println(result);
		ps.close();
		conn.close();
		return result;
	}
	
	//思考传什么好
	public int update() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		PreparedStatement ps=conn.prepareStatement("update emp set sal=?,comm=?  where empno=? ");
		ps.setInt(1, 1200);
		ps.setInt(2, 500);
		ps.setInt(3, 7369);
		int result=ps.executeUpdate();
		System.out.println(result);
		ps.close();
		conn.close();
		return result;
	}
	
	public int delById(int id) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user="root";
		String password="root";
		Connection conn=DriverManager.getConnection(url, user, password);
		PreparedStatement ps=conn.prepareStatement("delete from emp where empno=? ");
		ps.setInt(1, id);
		int result=ps.executeUpdate();
		System.out.println(result);
		ps.close();
		conn.close();
		return result;
	}
}
