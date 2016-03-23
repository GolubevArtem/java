package by.htp.library.dao.pool;

public class ConnectionPoolException extends Exception{
	public ConnectionPoolException(Exception e){
		super(e);
	}

	public ConnectionPoolException(String str){
		super(str);
	}

	public ConnectionPoolException(String str, Exception e){
		super(str, e);
	}
}
