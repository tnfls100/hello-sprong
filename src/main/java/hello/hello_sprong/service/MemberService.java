package hello.hello_sprong.service;

import java.util.Optional;

import hello.hello_sprong.domain.Member;
import hello.hello_sprong.repository.MemberRepotsitory;
import hello.hello_sprong.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepotsitory memberRepotsitory = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member){

        // 같은 이름이 있는 중복 회원은 불가능
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
    public List<member> findMebers(){
        
    }

}
