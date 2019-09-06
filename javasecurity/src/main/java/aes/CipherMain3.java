package aes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * userbackup2 테이블의 email 값을 암호화 하기.
 * key는 비밀번호 해쉬값의 앞 16자리로 정한다.
 */
public class CipherMain3 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/model1", "model1", "1234");
		
		PreparedStatement pstmt = conn.prepareStatement("select email, password, userid from userbackup2");
		ResultSet rs = pstmt.executeQuery();  // select 구문 실행.
		while(rs.next()) {
			String email = rs.getString(1);
			String pass = rs.getString(2).substring(0, 16);
			String id = rs.getString(3);
			if(email != null && !email.equals("")) {
				String cipherEmail = CipherUtil.encrypt(email, pass);
				System.out.println(id + "님의 email 암호화 : " + cipherEmail);				
				pstmt = conn.prepareStatement("update useraccount set email=? where userid=?");
				pstmt.setString(1, cipherEmail);
				pstmt.setString(2, id);
				pstmt.executeUpdate();  // insert, update, delete 구문 실행(executeQuery로 실행 하면 리턴값이 null). select도 실행은 되지만 리턴값이 다름.
//				pstmt.execute();  // 모든 구문 가능. 리턴타입 boolean. true이면 select 구문. false이면 그 외의 구문.
			}			
		}
		
	}
}
