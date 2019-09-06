package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.DuplicateMemberException;
import spring.MemberDeleteService;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.PasswordChangeService;
import spring.RegisterRequest;

public class Main2 {
	private static ApplicationContext ctx = null;
	public static void main(String[] arg) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);  // MemberRegisterService, MemberDao 두 개의 객체 저장.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			if(command.startsWith("new ")) {  // command 문자열의 시작이 "new "인 경우만 true.
				processNewCommand(command.split(" "));
				continue;  // 사실 의미 없음.
			} else if(command.startsWith("passchg ")) {
				/*
				 * passchg 이메일 변경전비밀번호 변경후비밀번호
				 * 이메일이 존재하지 않으면 MemberNotFoundException 예외 발생. "해당 회원이 존재하지 않습니다."
				 * 비밀번호를 변경후비밀번호로 변경. "비밀번호 변경 완료"
				 */
				processChangeCommand(command.split(" "));
				continue;
			} else if(command.startsWith("delete ")) {
				// delete 이메일
				MemberDeleteCommand(command.split(" "));
				continue;
			} else if(command.startsWith("list")) {
				processListCommand(command.split(" "));
				continue;
			}
			printHelp(arg);
		}
	}
	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp(arg);
			return;
		}
		/*
		 * arg[0] : new
		 * arg[1] : 이메일
		 * arg[2] : 이름
		 * arg[3] : 비밀번호
		 * arg[4] : 비밀번호 확인
		 */
//		MemberRegisterService regSvc = ctx.getBean("memberRegisterService", MemberRegisterService.class);  // 이 방법도 가능.
		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);  // getBean(클래스명)으로 직접 가져올 수 있음. 한 개뿐이라서 가능.
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 암호확인 불일치\n");
			return;
		}
		try {
			regSvc.regist(req);  // 등록 조건 모두 만족하면 실행.
			System.out.println("등록되었습니다.\n");
		} catch(DuplicateMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	private static void processListCommand(String[] arg) {
		MemberListPrinter listprinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listprinter.printAll();
	}

	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp(arg);
			return;
		}
		
		PasswordChangeService passSvc = ctx.getBean(PasswordChangeService.class);
		
		try {
			passSvc.change(arg);
			System.out.println("비밀번호 변경이 완료되었습니다.\n");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.");
			System.out.println(e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("변경전암호가 틀렸습니다.");
			System.out.println(e.getMessage());
		}
		
	}

	private static void MemberDeleteCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp(arg);
			return;
		}
		
		MemberDeleteService delSvc = ctx.getBean(MemberDeleteService.class);
		
		try {
			delSvc.delete(arg[1]);
			System.out.println("탈퇴가 완료되었습니다.\n");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다.");
			System.out.println(e.getMessage());
		}
	}

	private static void printHelp(String[] arg) {
		System.out.println("-----------------------------");
		System.out.println("\n잘못된 명령어입니다.");
		System.out.println("명령어 사용법");
		if(arg[0].startsWith("new")) {
			System.out.println("new 이메일 이름 암호 암호확인");
		} else if(arg[0].startsWith("passchg")) {
			System.out.println("passchg 이메일 변경전암호 변경후암호");
		}
		System.out.println("-----------------------------");
	}
}
