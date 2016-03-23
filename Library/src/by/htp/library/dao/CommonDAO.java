package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

public interface CommonDAO {
	
	User checkLogin(String login, int password) throws DAOException;

}
