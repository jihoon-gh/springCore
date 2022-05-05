package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;// 추상화와 구체화 둘 의존
    public MemberServiceImpl(MemberRepository memberRepository) { //의존관계를 외부(AppConfig)에서 주입
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {
        memberRepository.save(member); //MemoryMemberRepository의 save -> 다형성
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
