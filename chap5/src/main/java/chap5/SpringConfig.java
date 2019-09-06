package chap5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

// spring 3.0 이후 버전에서만 사용 가능.
// @Configuration : 환경 설정 해주는 클래스임을 알려줌. xml의 기능을 대체할 수 있는 클래스.
@Configuration
public class SpringConfig {
	// @Bean : 리턴 객체를 컨테이너에 저장. 메서드명이 Bean의 이름.
	/*
	 * <bean id="executor" class="chap5.Executor" p:worker-ref="worker" />  -ref : worker라는 객체가 따로 필요.
	 * <bean id="worker" class="chap5.Worker" ... />
	 */
	@Bean
	public Executor executor() {
		Executor exec = new Executor();
		exec.setWorker(worker());
		return exec;
	}
	@Bean
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)  // 일회성 객체로 생성.
	public Worker worker() {
		return new Worker();
	}
	@Bean
	public Camera camera1() {
		Camera c = new Camera();
		c.setNumber(1);
		return c;
	}
	@Bean
	public Camera camera2() {
		Camera c = new Camera();
		c.setNumber(2);
		return c;
	}
	@Bean
	public Camera camera3() {
		Camera c = new Camera();
		c.setNumber(3);
		return c;
	}
	@Bean
	public Camera camera4() {
		Camera c = new Camera();
		c.setNumber(4);
		return c;
	}
	@Bean
	public InfraredRaySensor windowSensor() {
		InfraredRaySensor s = new InfraredRaySensor("창센서");
		return s;
	}
	@Bean
	public InfraredRaySensor doorSensor() {
		InfraredRaySensor s = new InfraredRaySensor("현관센서");
		return s;
	}
	@Bean
	public InfraredRaySensor lampSensor() {
		InfraredRaySensor s = new InfraredRaySensor("전등센서");
		return s;
	}
	@Bean
	public AlarmDevice alarmDevice() {
		return new SmsAlarmDevice(); 
	}
	@Bean
	public Viewer viewer() {
		MonitorViewer v = new MonitorViewer();
		v.setDisplayMode(displayMode());  // Viewer에 DisplayMode 객체 주입.
		return v;
	}
	@Bean
	public DisplayMode displayMode() {  // DisplayMode 객체 생성.
		DisplayMode d = new DisplayMode();
		d.setType("GRID");
		return d;
	}
	
	// initMethod="init" : 객체 초기화(모든 객체의 주입 완료) 이후에 HomeController의 init() 메서드 호출.
	@Bean(initMethod="init")
	public HomeController homeController() {
		HomeController h = new HomeController();  // 이 상태는 객체의 생성이 완료된 것이 아님. 스프링에서는 의존관계에 있는 모든 객체들의 주입이 완료되어야 객체 생성이 완료 되었다고 함.
		List<InfraredRaySensor> sensors = new ArrayList<InfraredRaySensor>();
		sensors.add(windowSensor());
		sensors.add(doorSensor());
		sensors.add(lampSensor());
		h.setSensors(sensors);
		h.prepare(alarmDevice(), viewer());
		h.setCamera1(camera1());
		h.setCamera2(camera2());
		h.setCamera3(camera3());
		h.setCamera4(camera4());
//		h.init();  // 어노테이션에 조건 없이 메서드 호출 해도 됨.
		return h;
	}
}
