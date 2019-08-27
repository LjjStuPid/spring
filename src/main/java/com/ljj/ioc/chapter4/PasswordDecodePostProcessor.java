package com.ljj.ioc.chapter4;

import com.ljj.ioc.chapter4.impl.DowJonesNewsListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author liujj
 * @Description TODO
 * @Date 2019/8/26 16:14
 */
public class PasswordDecodePostProcessor implements BeanPostProcessor, InitializingBean {
    @Override
    public Object postProcessBeforeInitialization(Object object, String s) throws BeansException {
        System.out.println("测试" + object.getClass());
        if (object instanceof PasswordDecodable) {

            String encodedPassword = ((PasswordDecodable) object).getEncodedPassword();
            String decodedPassword = decodedPassword(encodedPassword);
            ((PasswordDecodable) object).setDecodedPassword(decodedPassword);
            return object;
        }

        return object;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String s) throws BeansException {
        return object;
    }

    private String decodedPassword(String encodedPassword) {
        return "123456";
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        DowJonesNewsListener dowJonesNewsListener = (DowJonesNewsListener) applicationContext.getBean("dowJonesNewsListener");
        System.out.println(dowJonesNewsListener);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
