package hello.hello_sprong.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hello_sprong.domain.Member;

class MemoryMemberRepositoryTest {

    MemberRepotsitory repotsitory = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("tory");

        repotsitory.save(member);

        Member result = repotsitory.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
        //assertThat(member).isEqualTo(result);

    }

}
