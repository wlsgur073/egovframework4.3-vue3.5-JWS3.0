package egovframework.example.config;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class EgovConfigValidation {

    @Bean
    public Validator getValidator(@Qualifier("messageSource") MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);

        // EL 의존성 없이 동작하는 ParameterMessageInterpolator 사용
        bean.setMessageInterpolator(new ParameterMessageInterpolator());

        // 초기화 메서드 명시적 호출
        bean.afterPropertiesSet();

        return bean;
    }

}
