package annotation;

import org.springframework.core.annotation.Order;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import xml.UpdateInfo;

@Component
@Aspect
@Order(1)
public class UpdateMemberInfoTraceAspect {
	@AfterReturning(pointcut="args(id, info)", argNames="ret, id, info", returning="ret")
	public void traceReturn(Object ret, String id, UpdateInfo info) {  // ret의 자료형을 Object로 해주면 void 메서드도 pointcut 대상이 될 수 있음.
		System.out.println("[TA] 정보 수정 : 결과=" + ret + ", 대상 ID=" + id + ", 수정 정보=" + info);
	}
}
