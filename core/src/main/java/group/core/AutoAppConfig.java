package group.core;

import group.core.discount.FixDiscountPolicy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "group.core",
        basePackageClasses = FixDiscountPolicy.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes=Configuration.class)
)
public class AutoAppConfig {

}

