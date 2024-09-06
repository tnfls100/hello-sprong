package hello.hello_sprong.service;

import java.util.List;
import java.util.Optional;

import hello.hello_sprong.domain.Member;
import hello.hello_sprong.repository.MemberRepotsitory;
import hello.hello_sprong.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepotsitory memberRepotsitory;

    public MemberService(MemberRepotsitory memberRepotsitory){
        this.memberRepotsitory = memberRepotsitory;
    }

    // 회원가입
    public Long join(Member member){

        // 중복 회원 검증
        validateDuplicateMember(member);

        memberRepotsitory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepotsitory.findByName(member.getName())
            .ifPresent(m ->{
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepotsitory.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepotsitory.findById(memberId);
    }

    

}
