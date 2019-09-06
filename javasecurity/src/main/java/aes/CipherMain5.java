package aes;

// 파일 암호화 하기
public class CipherMain5 {
	public static void main(String[] args) throws Exception {
		String key = "abc1234567";
		CipherUtil.encryptFile("aes_p1.txt", "asec.ser", key);  // p1.txt 파일을 읽어서 암호화 한 내용을 c.ser에 저장. 이 때 사용한 key도 파일로 저장.
	}
}
