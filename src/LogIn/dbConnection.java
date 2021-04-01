package LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class dbConnection {
	
	private static final String Connection = null;

	public static Connection getJBDCConnection() {
		final String url = "jdbc:mysql://http://localhost:8080/qlks_db" + "autoReconnect=true&useSSL=false";
		final String user = "root";
		final String password = "";
	
		try {
			final String DB_URL = "jdbc:mysql://localhost:8080/qlks_db";
			Connection conn = DriverManager.getConnection(DB_URL,"root","");
	} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			}
	
	return null;

}

public static void main(String[] args) {
	Connection connection =  getJBDCConnection();
	
	if (Connection != null) {
		System.out.println ("Thanhcong");
	} else {
		System.out.println("Thatbai");
	}
}
}