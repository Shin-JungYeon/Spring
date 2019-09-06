package chap2;

public class MessageEn implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, I'm " + name);
	}
}