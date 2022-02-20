package group.core.autowired;

import group.core.member.Grade;
import group.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean {

        @Autowired(required = false)
        void TestBean(Member noBean4){
            System.out.println("noBean4 = " + noBean4);
        }

        @Autowired(required=false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

        @Autowired
        public void noBeanTest(){
            Member test = new Member(1L,"hans", Grade.VIP);
            setNoBean1(test);
            setNoBean2(new Member(2L,"has", Grade.VIP));
        }
    }
}
