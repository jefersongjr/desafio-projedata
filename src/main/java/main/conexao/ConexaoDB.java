package main.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static Connection conectar() {
	    try {
		    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String oracleUrl = "jdbc:oracle:thin:@localhost:1521/xe";
			Connection con = DriverManager.getConnection(oracleUrl, "system", "secret_password");
			System.out.println("Connection established......");
			return con;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

