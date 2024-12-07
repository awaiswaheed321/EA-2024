package edu.miu.ea.springbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanCounter implements BeanPostProcessor {
    private Integer counter = 1;

    public BeanCounter() {
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        counter++;
        return bean;
    }

    public Integer getCounter() {
        return counter;
    }
}
