package alpha;

import java.sql.*;

import javax.xml.bind.DatatypeConverter;

import java.security.MessageDigest;

public class Update {
	
	static Connection connection = null;
	static Statement statement = null;
	
	public static int updateDevice(Bean b, String user) {
		
		int status = 0;
		String updatedevicename;
		
		try {
			
			connection = DBconnecter.getConnection();
			statement = connection.createStatement();
			updatedevicename = b.getUpdatedevicename();
			String sql = "update login set devicename = '"+ updatedevicename +"' where username = '"+ user +"'";
			status = statement.executeUpdate(sql);
			b.setDevicename(updatedevicename);
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static int updatepass(Bean b, String user) {
		
		int status = 0;
		String updatepassword;
		
		try {
			
			connection = DBconnecter.getConnection();
			statement = connection.createStatement();
			updatepassword = b.getUpdatepassword();
			
			MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
			byte[] bihash = messagedigest.digest(updatepassword.getBytes());
			String hash = DatatypeConverter.printHexBinary(bihash);
			String sql = "update login set password = '"+ hash +"' where username = '"+ user +"'";
			status = statement.executeUpdate(sql);
			b.setPassword(updatepassword);
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

	public static int updateUser(Bean b, String user) {

		int status = 0;
		String updateusername;

		try {

			connection = DBconnecter.getConnection();
			statement = connection.createStatement();
			updateusername = b.getUpdateusername();
			String sql = "update login set username = '"+ updateusername +"' where username ='"+ user +"'";
			status = statement.executeUpdate(sql);
			b.setUsername(updateusername);
			connection.close();
		} catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}



}
