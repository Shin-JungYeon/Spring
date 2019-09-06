package rsa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

/*
 * RSA : 공개키 암호 알고리즘. 비대칭키.
 * 			- 공개키로 암호화 -> 개인키로 복호화 가능.
 * 			- 개인키로 암호화 -> 공개키로 복호화 가능.
 */
public class CipherRSA {
	static Cipher cipher;
	static PrivateKey priKey;
	static PublicKey pubKey;
	static {
		try {
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");  // 대용량 데이터에는 잘 사용하지 않음. 키가 큼.
			key.initialize(2048);  // 키 크기가 2048로 매우 큼. -> 안정적인 암호화 가능.
			KeyPair keyPair = key.genKeyPair();
			priKey = keyPair.getPrivate();  // 개인키. 복호화에 사용하는 나만 가지고 있는 키. 개인키로 암호화 하고 공개키로 복호화 가능하면 부인 방지. 내가 했다는 것을 강조. (ex. 인증서)
			pubKey = keyPair.getPublic();  // 공개키. 암호화에 사용하는 키.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 암호화
	public static String encrypt(String plain) {
		byte[] cipherMsg = new byte[1024];
		try {
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			cipherMsg = cipher.doFinal(plain.getBytes());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return byteToHex(cipherMsg);
	}

	private static String byteToHex(byte[] cipherMsg) {
		if(cipherMsg == null) return null;
		int len = cipherMsg.length;
		String str = "";
		for(byte b : cipherMsg) {
			str += String.format("%02X", b);
		}
		return str;
	}

	// 복호화
	public static String decrypt(String cipherMsg) {
		byte[] plainMsg = new byte[1024];
		try {
			cipher.init(Cipher.DECRYPT_MODE, priKey);
			plainMsg = cipher.doFinal(hexToByte(cipherMsg.trim()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new String(plainMsg);
	}

	private static byte[] hexToByte(String str) {
		if(str == null || str.length() < 2) return null;
		byte[] buf = new byte[str.length()/2];
		for(int i=0; i<buf.length; i++) {
			buf[i] = (byte) Integer.parseInt(str.substring(i*2, i*2+2), 16);
		}
		return buf;
	}

	
	public static void getKey() {
		try {
			KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");  // RSA 방식의 키 생성.
			key.initialize(2048);  // 키의 크기는 2048bit
			KeyPair keyPair = key.generateKeyPair();  // 키의 쌍으로 설정.
			PrivateKey priKey = keyPair.getPrivate();  // 개인키 설정.
			PublicKey pubKey = keyPair.getPublic();  // 공개키 설정.
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("privateKey.ser"));  // 개인키를 저장할 파일의 이름 설정. ser : KeyPair 클래스는 Serializable(직렬화) 인터페이스를 구현한 클래스. Serializable 객체로 형변환 가능. 객체 여러 개 저장 가능..? (중요한건 아님.)
			out.writeObject(priKey);  // 개인키를 읽어서 파일에 저장. Object 객체로 저장. 다른 언어에서도 사용할 수 있게 하기 위해.
			out.flush();
			out.close();
			
			out = new ObjectOutputStream(new FileOutputStream("publicKey.ser"));  // 공개키를 저장할 파일의 이름 설정.
			out.writeObject(pubKey);  // 공개키를 읽어서 파일에 저장.
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void encryptFile(String plainFile, String cipherFile) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("privateKey.ser"));  // 개인키로 암호화하기 위해 개인키를 가져옴.
			PrivateKey priKey = (PrivateKey) ois.readObject();  // Object 객체이기 때문에 형변환 반드시 해줘야 함. 상속의 개념.
			ois.close();
			cipher.init(Cipher.ENCRYPT_MODE, priKey);  // 암호화 모드로 설정. 사용할 키는 개인키.
			FileInputStream fis = new FileInputStream(plainFile);  // 입력.
			FileOutputStream fos = new FileOutputStream(cipherFile);  // 출력.
			// 암호문은 반드시 InputStream, OutputSream으로 입출력. 문자형(텍스트 형태)이 아닌 바이트형이기 때문.
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);  // fis로 평문을 읽어서 cos로  암호화 후 fos(최종 목적지 : rsac.ser)에 저장.
			byte[] buf = new byte[1024];
			int len;
			while((len = fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void decryptFile(String cipherFile, String plainFile) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("publicKey.ser"));
			PublicKey pubKey = (PublicKey) ois.readObject();
			ois.close();
			cipher.init(Cipher.DECRYPT_MODE, pubKey);  // 복호화 모드로 설정. 개인키로 암호화 했기 때문에 복호화에 사용할 키는 공개키.
			
			FileInputStream fis = new FileInputStream(cipherFile);  // InputStream의 목적지는 나.
			FileOutputStream fos = new FileOutputStream(plainFile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);  // fis로 암호문을 읽어서 cos로  복호화 후 fos(최종 목적지 : rsa_p2.txt)에 저장.
			byte[] buf = new byte[1024];
			int len;
			while((len = fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			cos.close();
			fos.flush();
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
