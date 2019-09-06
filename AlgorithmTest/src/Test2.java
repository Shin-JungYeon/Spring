import java.util.Scanner;

/*
 * 1 ~ 15 중 내가 선택한 숫자 맟추기.
 */
public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String yesOrNo = null;
		int[] byteArr = new int[4];
		
		for(int i=0; i<byteArr.length; i++) {
			for(int j=0; j<16; j++) {
				
			}
			System.out.println("선택한 번호가 있으면 y 아니면 n을 입력하세요.");
			yesOrNo = scan.nextLine();
			if(yesOrNo.equalsIgnoreCase("y")) {
				byteArr[i] = 1;
			} else {
				byteArr[i] = 0;
			}
			
		}
			
		
	}
}
