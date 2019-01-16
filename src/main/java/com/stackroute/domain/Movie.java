package com.stackroute.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Movie implements ApplicationContextAware, BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private Actor actor;

    public Movie() {

    }

    public Movie(Actor actor) {
        this.actor = actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return this.actor;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // Used to set the properties of the bean before its initalized
        this.actor = (Actor) beanFactory.getBean("actorPrabhas");
        System.out.println("From BeanFactory Aware = "+actor.getName());
        System.out.println("From BeanFactory Aware = "+actor.getGender());
        System.out.println("From BeanFactory Aware = "+actor.getAge());
    }

    public void setBeanName(String s) {
        // Gets the bean names of all Movie beans and scope != prototype
        System.out.println("From BeanName Aware the name is =  "+s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // Used to set the properties of the bean before its initalized
        this.actor = (Actor) applicationContext.getBean("actorPrabhas");
        System.out.println("From Application Context Aware = "+actor.getName());
        System.out.println("From Application Context Aware = "+actor.getGender());
        System.out.println("From Application Context Aware = "+actor.getAge());
    }

    public void destroy() throws Exception {
        System.out.println("Inside destroy of Movie");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Inside afterPropertiesSet of Movie");
    }
}
