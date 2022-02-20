package group.core;

import group.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppConfigTest {

    @Test
    void 수동빈등록테스트(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext ac2 = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService bean = ac.getBean(MemberService.class);
        AppConfig bean2 = ac.getBean(AppConfig.class);
        System.out.println(bean);
        System.out.println(bean2);
    }

    @Test
    void 자동빈등록테스트(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService bean = ac.getBean(MemberService.class);
        AutoAppConfig bean2 = ac.getBean(AutoAppConfig.class);
        System.out.println(bean);
        System.out.println(bean2);
    }



}