package chap2;

public class MessageKr implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("반갑습니다. " + name + "입니다.");
	}
}
