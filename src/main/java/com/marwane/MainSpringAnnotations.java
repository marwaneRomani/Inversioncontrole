package com.marwane;

import com.marwane.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.marwane")
public class MainSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainSpringAnnotations.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat : " + metier.calcul());
    }
}
