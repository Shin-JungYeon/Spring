package main;

import xml.UpdateInfo;

public class MemberService2 {
	public void test(String str, UpdateInfo updateinfo) {  // traceAspect의 pointcut 대상임.
		System.out.println("MemberService2.test() 메서드 호출");
//		return false;
	}
}
