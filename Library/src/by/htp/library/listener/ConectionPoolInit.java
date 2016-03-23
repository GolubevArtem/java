package by.htp.library.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.htp.library.dao.pool.ConnectionPool;
import by.htp.library.dao.pool.ConnectionPoolException;

import org.gjt.mm.mysql.Driver;

public class ConectionPoolInit implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ConnectionPool.getInstance().desructConnectionPool();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try {
			
			ConnectionPool pool = ConnectionPool.getInstance();
			
		//	try {
				pool.init();

		//	} catch (ConnectionPoolException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
		} catch (ConnectionPoolException e) {
			throw new RuntimeException("DB init error");
		}
		
	}

}
