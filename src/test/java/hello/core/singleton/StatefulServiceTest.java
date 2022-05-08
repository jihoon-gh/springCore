package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingletone(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threadA : A사용자 만원 주문
        int userA = statefulService1.order("userA",10000);
        //threadB : B사용자 이만원 주문
        int userB = statefulService2.order("userB",20000);

        //ThreadA : 사용자 A 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = "+userA);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}