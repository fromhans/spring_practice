package group.core.beanfind;

import group.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object =" + bean);
        }
    }
    @Test
    @DisplayName("Application 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION: Spring 내부에서 등록한게 아니라 내가 개발하기 위해 등록된 빈듯
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("App bean / name = " + beanDefinitionName + " object =" + bean);
            }
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Infra bean / name = " + beanDefinitionName + " object =" + bean);
            }
        }
    }
}
