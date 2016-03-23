package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import by.htp.library.dao.CommonDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.dao.pool.ConnectionPool;
import by.htp.library.dao.pool.ConnectionPoolException;
import by.htp.library.entity.User;
import org.gjt.mm.mysql.Driver;


public class SQLCommonDAO implements CommonDAO{
	
	//private final static Logger logger = LogManager.getLogger("by.htp.library.dao.impl");

	@Override
	public User checkLogin(String login, int hashpass) throws DAOException {
	
		Connection con = null;		
		User user = null;

		try {
			con = ConnectionPool.getInstance().getConnection(); 

			String sql = "SELECT * FROM `Users` WHERE `LOGIN` = ? and PASSWORD = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ps.setInt(2, hashpass);
			ResultSet result = ps.executeQuery();

			
			if (result.next()){
				user = new User();
				user.setRole(result.getInt(4));

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
					//logger.error("соединение с БД не закрыто");
				}
			}
			
		}
		return user;
	}

}
