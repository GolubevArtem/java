package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.library.dao.CommonDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.dao.pool.ConnectionPool;
import by.htp.library.dao.pool.ConnectionPoolException;
import by.htp.library.entity.User;


public class SQLCommonDAO implements CommonDAO{

	@Override
	public User checkLogin(String login, String password) throws DAOException {
		
		Connection con = null;
		User user;
		try {
			con = ConnectionPool.getInstance().getConnection();
			String sql = "SELECT * FROM `Users` WHERE `LOGIN` = ? and PASSWORD = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			
			if (result.next()){
				user = new User();
				//fill
			}else{
				return null;
			}
			
			
		} catch (ConnectionPoolException | SQLException e) {
			throw new DAOException();
		}finally{
			if(con != null){
				try {
					ConnectionPool.getInstance().returnConnection(con);
				} catch (ConnectionPoolException e) {
					// log
				}
			}
			
		}
		return user;
	}

}
