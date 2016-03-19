package by.htp.library.dao.pool;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ConnectionPool {
	
	private static final ConnectionPool INSTANCE = new ConnectionPool(); 

	private final static Logger logger = LogManager.getLogger("by.htp.library.dao.pool");
	
	private BlockingQueue<Connection> freeConnections = new ArrayBlockingQueue<Connection>(5);

	public ConnectionPool() {
	}
	
	public void init() throws ConnectionPoolException{
		try {

			Class.forName("org.gjt.mm.mysql.Driver");

			for (int i = 0; i < freeConnections.size(); i++) {
				Connection con = DriverManager
						.getConnection("jdbc:mysql://localhost:8889/Library?characterEncoding=UTF-8", "root", "root");
				freeConnections.add(con);
			}
		} catch (SQLException e) {
			throw new ConnectionPoolException(e);
		} catch (ClassNotFoundException e) {
			throw new ConnectionPoolException(e);
		}
		
	}
	
	public Connection getConnection() throws ConnectionPoolException{
		try {
			return freeConnections.take();
		} catch (InterruptedException e) {
			throw new ConnectionPoolException(e);
		}
		
	}
	
	public void returnConnection(Connection con) throws ConnectionPoolException{
		if (con == null){
			throw new ConnectionPoolException("jhgjhgj");
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			throw new ConnectionPoolException("jhgjhgj");
		}
		try {
			freeConnections.put(con);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("jhgjhgj");
		}
		
	}
	
	public void desructConnectionPool(){
		for(int i = 0; i<5; i++){
			Connection con = null;
			try {
				con = freeConnections.take();
			} catch (InterruptedException e) {
				// log
				logger.error("соединение не создано");
			}
			try {
				con.close();
			} catch (SQLException e) {
				// log
				logger.error("соединение не закрыто");
			}
			
		}
		
	}
	
	public static ConnectionPool getInstance(){
		return INSTANCE;
		
	}

}
