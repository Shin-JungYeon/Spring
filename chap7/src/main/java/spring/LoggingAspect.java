package spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {  // logging 메서드 반드시 필요. 가장 먼저 실행(around : 시작과 끝). 호출 후 핵심 메서드를 다시 호출해줘야 함.
		System.out.println("[LA]로그 시작");
		StopWatch sw = new StopWatch();
		sw.start();
		Object ret = joinPoint.proceed();  // 다음 메서드 호출. 즉 핵심 메서드 호출.
		sw.stop();
		System.out.println("[LA]메서드 실행 시간 : " + sw.getTotalTimeMillis() + " 밀리초");
		return ret;  // 핵심 기능이 전달해준 객체. 리턴 값이 있으면 전달, 아니면 그냥.. 없는거지..
	}
}
