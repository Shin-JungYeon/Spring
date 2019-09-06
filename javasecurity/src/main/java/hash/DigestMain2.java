package hash;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * SHA-256 알고리즘을 이용하여 userbackup 테이블의 비밀번호를 해쉬값으로 변경하기.
 * 	1. Class.forName("드라이버")
 * 	2. DriverManager.getConnection(url, db사용자id, db사용자password)
 * 	3. PreparedStatement pstmt = conn.prepareStatement(sql);
 * 	4. ResultSet rs = pstmt.executeQuery();
 * 	   int cnt = pstmt.executeUpdate();
 */
public class DigestMain2 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");  // jar 파일 필요. -> Maven 이니까 pom.xml에 dependency 설정 필요.
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/model1", "model1", "1234");
		String selectSql = "select userid, password from useraccount";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		ResultSet rs = pstmt.executeQuery();
		byte[] hash = null;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		while(rs.next()) {
			String hashPass = "";
			hash = md.digest(rs.getString(2).getBytes());  // 해쉬암호 생성.
			for(byte b : hash) {
				hashPass += String.format("%02X", b);  // 헥사형태의 문자열로 저장. 02 -> 2자리로 하고, 빈자리는 0으로 채움.
			}
//			pstmt = conn.prepareStatement("update userbackup set password=? where userid=?");
//			pstmt.setString(1, hashPass);
//			pstmt.setString(2, rs.getString(1));
//			pstmt.execute();
			String updateSql = "update useraccount set password='" + hashPass + "' where userid='" + rs.getString(1) + "'";
			int cnt = pstmt.executeUpdate(updateSql);
			if(cnt > 0) continue;
		}
		
	}
}
