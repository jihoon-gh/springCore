package hello.core.scan.filter;
import java.lang.annotation.*;


@Target(ElementType.TYPE) //TYPE은 클래스 레벨에 붙는다는뜻
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}