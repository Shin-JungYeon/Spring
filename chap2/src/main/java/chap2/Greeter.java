package chap2;

public class Greeter {
	private String format;
	
	public String greet(String guest) {
		return String.format(format, guest);  // String.format("안녕하세요, %s", "스프링") : "스프링"이라는 문자열을 %s 형식으로 출력. xml의 %s의 위치에 따라 출력 결과 달라짐. 
	}
	
	public void setFormat(String format) {  // 반드시 존재해야 하는 메서드. format = "안녕하세요, %s"
		this.format = format;
	}
}
