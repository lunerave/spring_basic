package hellospring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 패키지를 설정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 탐색 위치
        // 탐색하고 싶은 패키지 설정, 하위 패키지까지 모두 탐색
//        basePackages = "hellospring.core.member",
        // 탐색하고 싶은 클래스 설정, 해당 클래스의 패키지를 탐색
//        basePackageClasses = AutoAppConfig.class,
        // 제외할 것들 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
