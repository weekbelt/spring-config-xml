XML을 이용한 Spring 설정 
========================

1. MavenPrjoect -> archetype: maven-archetype-quick-start 선택 후 프로젝트 생성

2. test하위 패키지 안에 AppTest 실행 -> 성공할 경우 제대로된 MavenProject 생성 신호

3. DI 테스트 실행
    * Bean객체 생성
        * Bean의 특징
            1. 기본생성자를 가지고 있다.
            2. 필드는 private하게 선언한다.
            3. getter, setter 메소드를 가진다
            4. getName(), setName()과 같은 메소드를 name 프로퍼티(property)라고 한다.
    * Pom.xml에 spring관련 의존성 추가
    ~~~
    <spring.version> 4.3.14.RELEASE</spring.version>
    
    <!-- Spring -->
    <dependency>
    	<groupId>org.springframework</groupId>
    	<artifactId>spring-context</artifactId>
    	<version>${spring.version}</version>
    </dependency>
    ~~~
    
4. main폴더 밑에 resources폴더 생성 -> resources폴더 하위에 applicationContext.xml 파일 생성
    * applicationContext.xml에 userBean이라는 id로 kr.or.connct패키지안에 있는 UserBean.class를 빈으로 등록
    ~~~
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
        <bean id="userBean" class="kr.or.connct.UserBean"></bean>
    
    </beans>
    ~~~
5. 등록한 빈을 불러올 클래스 생성
    ~~~
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("초기화 완료!!");

        UserBean userBean = (UserBean) ac.getBean("userBean");
        userBean.setName("joohyuk");
        userBean.setAge(30);

        System.out.println(userBean.getName());
        System.out.println(userBean.getAge());
    }
    ~~~
    ApplicationContext를 생성하게되면 applicationContext.xml에 등록한 빈의 정보를 모두 일어들여 메모리에 올려 놓는다.