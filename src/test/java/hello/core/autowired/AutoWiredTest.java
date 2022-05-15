package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.security.AccessControlContext;
import java.util.Optional;

public class AutoWiredTest {
    @Test
    void AuotoWiredOption(){
         ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)
        public void SetNoBean1(Member noBean1){
            System.out.println("Member1 = " + noBean1);
        }
        @Autowired
        public void SetNoBean2(@Nullable Member noBean2){
            System.out.println("Member2 = " + noBean2);
        }
        @Autowired
        public void SetNoBean3(Optional<Member> noBean3){
            System.out.println("Member3 = " + noBean3);
        }
    }
}
