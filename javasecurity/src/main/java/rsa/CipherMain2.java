package rsa;

public class CipherMain2 {
	public static void main(String[] args) {
		CipherRSA.getKey();
		CipherRSA.encryptFile("rsa_p1.txt", "rsac.ser");
	}
}