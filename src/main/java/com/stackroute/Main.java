package com.stackroute;


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
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Movie movie1 = (Movie) beanFactory.getBean("movieRRR");
        System.out.println("Actor Name using BeanFactory = " + movie1.getActor().getName());

        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        beanDefinitionReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie2 = ((DefaultListableBeanFactory) beanDefinitionRegistry).getBean(Movie.class);
        System.out.println("Actor Name using BeanDefRegistry = "+movie2.getActor().getName());

        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3=(Movie) context.getBean("movieRRR");
        System.out.println("Actor Name using Application Context = "+movie3.getActor().getName());



    }
}
