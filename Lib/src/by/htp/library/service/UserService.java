package by.htp.library.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.htp.library.dao.CommonDAO;
import by.htp.library.dao.DAOFactory;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.exception.ServiceException;

public final class UserService {
	
	public final static User checkLogin(String login, String password) throws ServiceException{
		// validation
		
		//hash password
		
		CommonDAO dao = DAOFactory.getInstance().getCommonDAO();
		try {
			User user = dao.checkLogin(login, password);
			return user;
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		

	}

	
	public int hashCode(String password) {
		int result = 1;
		result = 1205 *(result + password.hashCode());
		return result;
	}
	
	 
	
	static class Validator{
		public static boolean loginValidator(String login, String password){
			if(login.isEmpty()){
				return false;
			}
			if(password.isEmpty()){
				return false;
			}
			return true;
		}
	}
}
