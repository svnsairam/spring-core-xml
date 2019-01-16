package com.stackroute;


import com.stackroute.domain.Categories;
import com.stackroute.domain.Movie;
import com.stackroute.domain.Triangle;
import com.stackroute.domain.Point;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie1 = (Movie) context.getBean("movieBB2");
        System.out.println("Actor Name using Application Context and AutoWiring= " + movie1.getActor().getName());
        System.out.println("Actor Gender using Application Context and AutoWiring = " + movie1.getActor().getGender());
        System.out.println("Actor Age using Application Context and AutoWiring = " + movie1.getActor().getAge());

        Resource res = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(res);

        Object o = factory.getBean("id1");
        Categories wb = (Categories) o;

        wb.show();

        Categories wwb = (Categories) context.getBean("id1");
        wwb.show();

        Triangle triangle = (Triangle) context.getBean("triangle");
        System.out.println(triangle.getMyPoints());
    }
}
