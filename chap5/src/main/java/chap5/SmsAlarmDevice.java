package chap5;

public class SmsAlarmDevice implements AlarmDevice {
	public void alarm(String name) {
		System.out.println(name + "에서 침입이 탐지 됨. 신고 요망.");
	}
}
