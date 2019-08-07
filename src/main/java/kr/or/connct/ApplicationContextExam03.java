package kr.or.connct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam03 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);

        Car car = (Car) ac.getBean(Car.class);
        car.run();

    }
}
