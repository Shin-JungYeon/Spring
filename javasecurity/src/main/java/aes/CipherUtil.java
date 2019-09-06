package aes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtil {
	private static byte[] randomKey;
	
	private final static byte[] iv = new byte[] {  // 초기화 벡터. 키 크기와 똑같이 맞춰줌. 128bit
			(byte)0x8E,0x12,0x39,(byte)0x9C,
				  0x07,0x72,0x6F,(byte)0x5A,
			(byte)0x8E,0x12,0x39,(byte)0x9C,
				  0x07,0x72,0x6F,(byte)0x5A
	};
	
	static Cipher cipher;
	
	static {  // 초기화 블록. cipher 객체 초기화.
		try {
			// CBC모드 : 블록모드. 평문을 블록화. iv에 따라 암호문이 달라짐. -> 앞의 암호화 블록이 뒤의 블록에 입력값으로 들어감. 제일 앞의 블록은 그 앞에 암호화 블록이 없기 때문에 초기화 벡터 필요. (평문이 같으면 암호문도 같은건 EBC) 
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  // AEC알고리즘/CBC모드(블록모드)/padding
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] getRandomKey(String algo) throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance(algo);  // AES 알고리즘에 사용할 키 자동으로 생성.
		keyGen.init(128);  // 각 알고리즘별로 가능한 키 크기가 정해져 있음. AES : 128bit
		SecretKey key = keyGen.generateKey();
		return key.getEncoded();
	}
	
	public static String encrypt(String plain) {
		byte[] cipherMsg = new byte[1024];
		try {
			randomKey = getRandomKey("AES");  // AES 암호 알고리즘 용 128bit짜리 key.
			Key key = new SecretKeySpec(randomKey, "AES");
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);  // CBC방식에서는 필요.
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);  // AES 알고리즘으로 암호화 모드로 암호 객체 초기화.
			cipherMsg = cipher.doFinal(paddingString(plain).getBytes());  // 암호문 생성.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return byteToHex(cipherMsg).trim();
	}
	
	public static String encrypt(String plain, String key) {
		byte[] cipherMsg = new byte[1024];
		try {
			Key genKey = new SecretKeySpec(makeKey(key), "AES");  // key : 16bit짜리로 맞춰줘야 함.
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);  // CBC방식에서는 필요.
			cipher.init(Cipher.ENCRYPT_MODE, genKey, paramSpec);  // AES 알고리즘으로 암호화 모드로 암호 객체 초기화.
			cipherMsg = cipher.doFinal(plain.getBytes());  // 암호문 생성.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return byteToHex(cipherMsg).trim();
	}
	
	public static void encryptFile(String plainFile, String cipherFile, String strKey) {
		try {
			getKey(strKey);  // key를 파일로 저장.
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
			Key key = (Key) ois.readObject();
			ois.close();
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			FileInputStream fis = new FileInputStream(plainFile);
			FileOutputStream fos = new FileOutputStream(cipherFile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);  // 암호문 출력.
			byte[] buf = new byte[1024];
			int len;  // 읽어 온 바이트 수 저장.
			while((len=fis.read(buf)) != -1) {
				cos.write(buf, 0, len);  // write() : 외부에 쓰는 것(출력).
										 // read() : 외부로부터 읽어오는 것(입력).
			}
			fis.close();
			cos.flush();
			fos.flush();
			cos.close();
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getKey(String key) throws Exception {
		Key genKey = new SecretKeySpec(makeKey(key), "AES");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("key.ser"));
		out.writeObject(genKey);
		out.flush();
		out.close();
	}

	public static String decrypt(String cipherMsg) {
		byte[] plainMsg = new byte[1024];
		try {
			Key key = new SecretKeySpec(randomKey, "AES");
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);  // 복호화 모드로 암호화 객체를 초기화.
			plainMsg = cipher.doFinal(hexaToByte(cipherMsg.trim()));  // byte형 배열 -> 복호화 완성.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new String(plainMsg).trim();
	}
	
	public static String decrypt(String cipherMsg, String key) {
		byte[] plainMsg = new byte[1024];
		try {
			Key genKey = new SecretKeySpec(makeKey(key), "AES");
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, genKey, paramSpec);  // 복호화 모드로 암호화 객체를 초기화.
			plainMsg = cipher.doFinal(hexaToByte(cipherMsg.trim()));  // byte형 배열 -> 복호화 완성.
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new String(plainMsg).trim();
	}

	public static void decryptFile(String cipherFile, String plainFile) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("key.ser"));
			Key key = (Key) ois.readObject();
			ois.close();
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			FileInputStream fis = new FileInputStream(cipherFile);
			FileOutputStream fos = new FileOutputStream(plainFile);
			CipherOutputStream cos = new CipherOutputStream(fos, cipher);
			byte[] buf = new byte[1024];
			int len;
			while((len=fis.read(buf)) != -1) {
				cos.write(buf, 0, len);
			}
			fis.close();
			cos.flush();
			fos.flush();
			cos.close();
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static byte[] makeKey(String key) {  // key의 크기를 16byte로 만들어 줌.
		int len = key.length();
		char ch = 'A';
		for(int i=len; i<16; i++) {
			key += ch++;  // 키의 크기를 맞춰주기 위한 더하기.
		}
		return key.substring(0, 16).getBytes();  // 16byte보다 크면 자름.
	}

	private static String paddingString(String plain) {  // 8, 16, 32, ... 문자열 길이 맞춰주기 위함.
		char paddingChar = ' ';
		int size = 16;
		int x = plain.length() % size;
		int len = size - x;
		for(int i=0; i<len; i++) {
			plain += paddingChar;
		}
		return plain;
	}
	
	private static String byteToHex(byte[] cipherMsg) {
		if(cipherMsg == null) return null;
		String str = "";
		for(byte b : cipherMsg) {
			str += String.format("%02X", b);  // 암호를 헥사로 출력하기 위함. 보여주기 위함.
		}
		return str;
	}
		
	private static byte[] hexaToByte(String str) {
		if(str == null) return null;
		if(str.length() < 2) return null;  // 헥사값은 최소 2개임.
		int len = str.length()/2;
		byte[] buf = new byte[len];
		for(int i=0; i<len; i++) {
			buf[i] = (byte) Integer.parseInt(str.substring(i*2, i*2+2), 16);  // substring : i*2+2 번 째는 포함 X.
		}
		return buf;
	}


} 