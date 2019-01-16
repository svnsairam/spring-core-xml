package com.stackroute.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycleDemoBean implements InitializingBean, DisposableBean {
    public void afterPropertiesSet() throws Exception {
        System.out.println("inside afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("inside destroy");
    }
    public void customInit() throws Exception {
        System.out.println("inside customInit");

    }

    public void customDestroy() throws Exception {
        System.out.println("inside custom destroy");

    }
    public void customDestroy2() throws Exception {
        System.out.println("inside custom destroy 2");

    }
}
