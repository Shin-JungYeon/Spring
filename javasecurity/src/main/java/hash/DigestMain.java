package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 해쉬암호 : 암호화만 가능. 복호화 불가능.
 */
public class DigestMain {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] plain = null;
		byte[] hash = null;
		String[] algo = {"MD5", "SHA-1", "SHA-256", "SHA-512"};  // 해쉬 암호 알고리즘 종류.
		System.out.println("해쉬값을 구할 문자열을 입력하세요.");
		plain = br.readLine().getBytes();  // byte형태만 변환 가능.
		System.out.println("평문 : " + new String(plain));
		for(String al : algo) {
			MessageDigest md = MessageDigest.getInstance(al);
			hash = md.digest(plain);  // 해쉬 암호 생성.
			System.out.println(al + " 해쉬값 크기 : " + (hash.length*8) + "bits");  // 크기는 항상 고정. 크기가 작을 수록 충돌(다른 문자가 같은 암호값을 가짐) 가능성 커짐. -> 크기 클수록 좋음. 1byte=8bit
			System.out.println("암호문 : ");
			for(byte b : hash) {
				System.out.printf("%02X", b);  // 16진수. 헥사값.
			}
			System.out.println();
		}
	} 
}