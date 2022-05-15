package hello.core.order;

import hello.core.annotaition.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //생성자 주입만 final을 사용할 수 있음
    private final DiscountPolicy discountPolicy;// 수정자 , 필드 주입, 메소드 사용 등은 final 못 씀
    //생성자 방식과 수정자 방식. 수정자(setter) 방식 -> 선택, 변경 가능성이 있는 친구
    @Autowired // 생성자가 딱 하나 있으면 굳이 Autowired 안붙여도 됨. 자동으로 의존관계 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //지금 롬복의 RequiredArgsConstructor 이용해서 생성자 만드러버림.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
