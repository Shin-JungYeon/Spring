import java.util.Scanner;

/*
 * 1 ~ 15 �� ���� ������ ���� ���߱�.
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String yesOrNo = null;
		int[] byteArr = new int[4];
		
		for(int i=0; i<byteArr.length; i++) {
			for(int j=0; j<16; j++) {
				
			}
			System.out.println("������ ��ȣ�� ������ y �ƴϸ� n�� �Է��ϼ���.");
			yesOrNo = scan.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				byteArr[i] = 1;
			} else {
				byteArr[i] = 0;
			}
			
		}
			
		
	}
}
