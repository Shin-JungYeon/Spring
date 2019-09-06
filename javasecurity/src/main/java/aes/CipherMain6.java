package aes;

// 파일 복호화 하기
public class CipherMain6 {
	public static void main(String[] args) throws Exception {
		CipherUtil.decryptFile("aesc.ser", "aes_p2.txt");
	}
}
