package aes;

/*
 * AES 암호화 예제2 : key 직접 설정. 암호문 실행마다 같음.
 */
public class CipherMain2 {
	public static void main(String[] args) {
		String plain1 = "안녕하세요. 홍길동입니다.";
		String key = "abc1234567";  // key 지정.
		String cipher1 = CipherUtil.encrypt(plain1, key);
		System.out.println("암호문 : " + cipher1);
		String plain2 = CipherUtil.decrypt(cipher1, key);  // plain2는 plain1과 같아야 함.
		System.out.println("복호문 : " + plain2);
	}
}