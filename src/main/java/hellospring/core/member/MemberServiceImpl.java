package hellospring.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //의존관계 주입을 자동으로 하기 위해서 사용 -> 컴포넌트 스캔 사용시에 필요함. 마치 ac.getBean(MemberRepository.class)
    //생성자에 붙여줘야한다
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //For test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
