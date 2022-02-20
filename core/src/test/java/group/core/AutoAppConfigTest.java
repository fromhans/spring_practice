package group.core;

import group.core.member.MemberRepository;
import group.core.member.MemberService;
import group.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        System.out.println(bean.getDiscountPolicy());
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepo = " + memberRepository);
    }
}