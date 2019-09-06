package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"spring"})  // spring 패키지에 있는 클래스 중 @Component 어노테이션 있는 모든 클래스 객체화.
public class AppCtx {
}
