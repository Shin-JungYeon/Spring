package spring;

public class DuplicateMemberException extends RuntimeException {  // RuntimeException 을 상속 받아 예외처리가 필요 없는 예외.
	public DuplicateMemberException(String message) {
		super(message);
	}
}
