package git;
//添加方法里传什么？
	//修改方法里传什么
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.jdbc.day01.Emp;
public class JdbcHomeWorkDay01 {
	//模糊查询怎么写？  比如查询姓名里包含s的人员信息
	public List<Emp> findLIKE(String ename) {
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<Emp> empList=new ArrayList();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/java11?characterEncoding=UTF-8&useUnicode=true";
		String user = "root";
		String password = "root";
		
		conn = DriverManager.getConnection(url, user, password);
		
		
		ps = conn.prepareStatement("select * from emp where ename like ?");
		ps.setString(1, '%'+ename+'%');
		rs = ps.executeQuery();
		
		
		while (rs.next()) {
		  
			Emp emp=new Emp();
		
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setComm(rs.getInt("comm"));
			emp.setDeptno(rs.getInt("deptno"));
			emp.setHiredate(rs.getString("hiredate"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setSal(rs.getInt("sal"));
			empList.add(emp);
			System.out.println(emp.getEname());
		}
		
		
		} catch (ClassNotFoundException e) {
			System.out.println("驱动错误");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("操作数据库错误");
			e.printStackTrace();
		}finally{
		
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
public static void main(String[] args) {
	JdbcHomeWorkDay01 jd=new JdbcHomeWorkDay01();
	List li=jd.findLIKE("s");
	
}
}
