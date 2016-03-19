package by.htp.library.dao;

import by.htp.library.dao.impl.SQLCommonDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
	
	public DAOFactory(){}
	
	private final CommonDAO commanDAO = new SQLCommonDAO(); 
	
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}
	
	public CommonDAO getCommonDAO(){
		return commanDAO;
	}
	
	
	
	
}
