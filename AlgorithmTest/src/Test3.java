import java.util.HashSet;
import java.util.Set;

/*
 * 홀수 개의 배열 중 짝이 없는 숫자 찾기.
 */
public class Test3 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 1, 7, 2, 3, 4, 5, 6, 3, 4, 5, 6, 9, 8, 9, 8, 10, 11, 12, 10, 11, 12, 1, 7};
		System.out.println("외톨이 숫자 : " + solution1(arr));
		System.out.println("외톨이 숫자 : " + solution2(arr));
		System.out.println("외톨이 숫자 : " + solution3(arr));
	}
	
	public static int solution1(int arr[]) {
		String remain="";
		for(int a : arr) {
			System.out.print(a + " ");
			String val = "-" + a + "-";
			if(remain.contains(val)) {
				remain = remain.replace(val, "");
			} else {
				remain += val;
			}
		}
		System.out.println();
		remain = remain.replace("-", "");
		return Integer.parseInt(remain);
	}
	
	public static String solution2(int[] arr) {
		Set<Integer> set = new HashSet<Integer>();
		for(int a : arr) {
			if(!set.add(a)) {
				set.remove(a);
			}
		}
		String result = "";
		for(Integer s : set) {
			result += s;
		}
		return result;
	}
	
	public static int solution3(int arr[]) {
		int solNum = 0;
		for(int a : arr) {
			int cnt = 0;
			for(int ar : arr) {
				if(a == ar) {
					cnt++;
				}
			}
			if(cnt%2 == 1) {
				solNum = a;
			}
		}
		return solNum;
	}
}
