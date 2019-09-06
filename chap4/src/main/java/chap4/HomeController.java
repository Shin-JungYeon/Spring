package chap4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/*
 * @Component : xml 설정에 의해 객체화 대상이 됨. -> 객체화 되어 컨테이너에 저장될 클래스.
 * 				이름은 homeController 형태로 저장.
 * xml 구조로 표현
 * 	<bean id="homeController" class"chap4.HomeController" >
 * 	...
 * 	</bean>
 */
@Component
public class HomeController {
	private AlarmDevice alarmDevice;
	private Viewer viewer;
	
	// @Resource : 컨테이너에서 이름이 camera1인 객체를 camera1 참조변수에 저장. 이름으로 객체를 찾아서 주입.
	@Resource(name="camera1")
	private Camera camera1;  // 어노테이션에 의해 접근제어자가 private임에도 불구하고 접근(변형) 가능.
	@Resource(name="camera2")
	private Camera camera2;
	@Resource(name="camera3")
	private Camera camera3;
	@Resource(name="camera4")
	private Camera camera4;
	
	private List<InfraredRaySensor> sensors;
	
	// @Autowired(required=false) : 자료형으로 객체를 찾아서 주입. 단 required=false 라는 조건때문에 객체가 없어도 오류 없이 실행 가능. -> null. 조건의 기본값은 true.
	@Autowired(required=false)
	private Recorder recorder;
	
	// alarmDevice : AlarmDevice 인터페이스를 구현한 SmsAlarmDevice 클래스(AlarmDevice 타입으로 형변환 가능) 객체를 주입 받음.
	// viewer : Viewer 인터페이스를 구현한 MonitorViewer 클래스(Viewer 타입으로 형변환 가능) 객체를 주입 받음.
	@Autowired
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		this.alarmDevice = alarmDevice;
		this.viewer = viewer;
	}
	
	// @PostConstruct : HomeController 객체의 생성(주입)이 완료 된 후 호출 되는 메서드.
	@PostConstruct
	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
		viewer.draw();
	}
	
	// @Autowired : 자료형으로 객체를 찾아서 주입. 자료형에 맞는 객체가 없으면 오류.
	// @Qualifier("intrusionDetection") : 객체 여러 개 중 별명이 intrusionDetection인 객체만 주입.
	@Autowired  // InfraredRaySensor 객체들로 이루어진 List 객체가 주입.
	@Qualifier("intrusionDetection")
	public void setSensors(List<InfraredRaySensor> sensors) {
		this.sensors = sensors;
		for(InfraredRaySensor s : sensors) {
			System.out.println("센서 등록 : " + s);  // 콘솔창에 가장 먼저 찍힘.
		}
	}
	
	// Main1.java에서 호출하는 메서드.
	public void checkSensorAndAlarm() {
		for(InfraredRaySensor s : sensors) {
			if(s.isObjectFounded()) {
				alarmDevice.alarm(s.getName());
			}
		}
	}
}