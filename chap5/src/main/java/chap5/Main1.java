package chap5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		
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
		sensor = ctx.getBean("doorSensor", InfraredRaySensor.class);  // 내 컨테이너에 있는 객체. sensors가 List이므로 추가가 되는 것.
		sensor.foundObject();
		home.checkSensorAndAlarm();
	}
}
