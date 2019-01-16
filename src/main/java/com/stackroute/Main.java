package com.stackroute;

import com.stackroute.demo.BeanLifecycleDemoBean;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie1 = (Movie) context.getBean("movieSVSC");
        // Even though the ref="actorMahesh" we get the Prabhas,male,38  because we have pre-setted the actor properties
        // (this.actor) before a movie bean is created
        // of movie bean using setApplicationContext & setBeanFactory methods which are present in Movie Class.
        System.out.println("Actor Name using Application Context and AutoWiring= " + movie1.getActor().getName());
        System.out.println("Actor Gender using Application Context and AutoWiring = " + movie1.getActor().getGender());
        System.out.println("Actor Age using Application Context and AutoWiring = " + movie1.getActor().getAge());

        Movie movie2 = (Movie) context.getBean("movieRRR");
        // Since the of the Movie bean wiht id="movieRRR" has scope = "prototype" it is not pre-setted its properties
        // But when we try to create bean it will again pre-set the properties (this.actor) using the
        // setApplicationContext & setBeanFactory methods which are present in Movie Class.
        System.out.println("Actor Name using Application Context and AutoWiring= " + movie2.getActor().getName());
        System.out.println("Actor Gender using Application Context and AutoWiring = " + movie2.getActor().getGender());
        System.out.println("Actor Age using Application Context and AutoWiring = " + movie2.getActor().getAge());

        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }

}
