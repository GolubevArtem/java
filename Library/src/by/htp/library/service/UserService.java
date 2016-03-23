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



	public final static User checkLogin(String login, String password) throws ServiceException {  
		
		
	
		if (Validator.loginValidator(login, password)) { 
			throw new ServiceException("Login or password is empty");
		} else {

			CommonDAO dao = DAOFactory.getInstance().getCommonDAO();
			int hashPass = 12*password.hashCode()+ 5*login.hashCode();
			try {
				User user = dao.checkLogin(login, hashPass); 
				return user;
			} catch (DAOException e) {
				throw new ServiceException("no dao check");
			}
		}

	}


	/*
	public  int hashCode(String pass) {
		int result = 1;		
		result = 1205 * (result + 23*pass.hashCode() + pass.hashCode());
		return result;
	} */

	static class Validator {
		public static boolean loginValidator(String login, String password) {
			if (login.isEmpty()) {
				return true;
			}
			if (password.isEmpty()) {
				return true;
				
			}
			return false;
		}
	}
}
