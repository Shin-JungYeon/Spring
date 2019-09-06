package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 화면에서 아이디와 비밀번호를 입력받아서
 * 해당 아이디가 userbackup 테이블에 없으면 "아이디 확인" 출력.
 * 해당 아이디의 비밀번호가 맞으면 "반갑습니다. 아이디님" 출력.
 * 해당 아이디의 비밀번호가 틀리면 "비밀번호 확인" 출력.
 */
public class DigestMain3 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");  // jar 파일 필요. -> Maven 이니까 pom.xml에 dependency 설정 필요.
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/model1", "model1", "1234");
		
		byte[] hash = null;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("아이디를 입력하세요.");
		String id = br.readLine();
		String selectSql = "select userid, password from userbackup where userid=?";
		PreparedStatement pstmt = conn.prepareStatement(selectSql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(!rs.next()) {
			System.out.println("아이디 확인");
		} else {
			System.out.println("비밀번호를 입력하세요.");
			String password = br.readLine();
			String hashPass = "";
			hash = md.digest(password.getBytes());  // 해쉬암호 생성.
			for(byte b : hash) {
				hashPass += String.format("%02X", b);  // 헥사형태의 문자열로 저장. 02 -> 2자리로 하고, 빈자리는 0으로 채움.
			}
			
			if(rs.getString(2).equals(hashPass)) {
				System.out.println("반갑습니다. " + id + "님");
			} else {
				System.out.println("비밀번호 확인");
			}
		}	
	}
}
