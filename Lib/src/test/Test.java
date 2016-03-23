package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.library.dao.pool.ConnectionPool;
import by.htp.library.dao.pool.ConnectionPoolException;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, ConnectionPoolException {
		
		Connection con = null;
		
		try {
		ConnectionPool.getInstance().init();
			System.out.println("1 ");
			
				String sql = "SELECT * FROM `Users` WHERE `LOGIN` = ?";
				PreparedStatement ps;
				ps = con.prepareStatement(sql);
				ps.setString(1, "admin");
				//ps.setString(2, "463928035");
				ResultSet result = ps.executeQuery();
				
				while (result.next()) {
					System.out.println(result);
				}

			} catch (SQLException e) {
			} finally {
				try {
					if (con != null) {

						con.close();
						System.out.println("Соединение закрыто!!");
					}
				} catch (SQLException e) {
				}
			}

		}

	}
