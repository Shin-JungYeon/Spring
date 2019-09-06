package aes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CipherMain4 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/model1", "model1", "1234");
		
		PreparedStatement pstmt = conn.prepareStatement("select email, password, userid from useraccount");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String email = rs.getString(1);
			String pass = rs.getString(2);
			String id = rs.getString(3);
			if(email != null && !email.equals("")) {
				String plainEmail = CipherUtil.decrypt(email, pass);
				System.out.println(id + "님의 email 복호화 : " + plainEmail);				
			}
		}
	}
}