package chap4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:annotation.xml");  // annotation.xml 이 가지고 있는 설정 정보 저장. component-scan 에 의해 객체를 미리 만들어놓음.
		
		Executor exec = ctx.getBean("executor", Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		
		HomeController home = ctx.getBean("homeController", HomeController.class);  // HomeController는 annotation에 존재하지 않음.
		home.checkSensorAndAlarm();
		System.out.println("침입 없음 ========================");
		
		InfraredRaySensor sensor = ctx.getBean("windowSensor", InfraredRaySensor.class);
		sensor.foundObject();
		home.checkSensorAndAlarm();
		System.out.println("===============================");
//		sensor = new InfraredRaySensor("현관센서");  // 새로운 객체. 내 컨테이너에 있는 객체가 아님. 새로운 객체를 쓸 것인지, 컨테이너에 있는 객체를 쓸 것인지 결정 필요. 코딩이 달라짐.
		sensor = ctx.getBean("doorSensor", InfraredRaySensor.class);  // 내 컨테이너에 있는 객체. sensors가 List이므로 추가가 되는 것.
		sensor.foundObject();
		home.checkSensorAndAlarm();
	}
}
