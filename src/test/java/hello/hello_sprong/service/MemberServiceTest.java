package hello.hello_sprong.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hello_sprong.domain.Member;
import hello.hello_sprong.repository.MemberRepotsitory;
import hello.hello_sprong.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService;
    MemberRepotsitory memberRepotsitory;

    @BeforeEach
    public void beforeEach(){
        memberRepotsitory = new MemoryMemberRepository();
        memberService = new MemberService(memberRepotsitory);
    }

    @Test
    void testFindMembers() {

    }

    @Test
    void testFindOne() {

    }

    @Test
    void testJoin() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then    
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

        
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("hello1");

        Member member2 = new Member();
        member2.setName("hello1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        //then 

    }
}
