package com.stackroute.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorDemoBean implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("I AM inside postProcessBeforeInitialization " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("I AM inside postProcessAfterInitialization " + beanName);
        return bean;
    }
}
