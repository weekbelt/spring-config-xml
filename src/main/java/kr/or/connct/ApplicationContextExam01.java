package kr.or.connct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("초기화 완료!!");

        UserBean userBean = (UserBean) ac.getBean("userBean");
        userBean.setName("joohyuk");
        userBean.setAge(30);

        System.out.println(userBean.getName());
        System.out.println(userBean.getAge());
    }
}
