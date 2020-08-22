package com.neusoft.elm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.util.DBUtil;
public class BusinessDaoImpl implements IBusinessDao {

	@Override
	public int add(Business Business) {
		Connection conn = null;

		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into business values(null,?,?,null,null,null,null)");

			ps.setString(1, Business.getBusinessName());

			ps.setString(2, Business.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeConnection(null, ps, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Business findByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Business Business=null;
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement("select * from business where businessName=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				Business=new Business();
				Business.setBusinessId(rs.getInt("businessid"));
				Business.setPassword(rs.getString("password"));
				Business.setBusinessName(rs.getString("businessName"));
				Business.setBusinessAddress(rs.getString("businessAdress"));
				Business.setBusinessExplain(rs.getString("businessExplain"));
				Business.setStarPrice(rs.getDouble("starPrice"));
				Business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtil.closeConnection(rs, ps, conn);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return Business;
	}
	}


