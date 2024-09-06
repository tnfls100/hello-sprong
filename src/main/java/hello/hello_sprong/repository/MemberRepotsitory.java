package hello.hello_sprong.repository;

import java.util.List;
import java.util.Optional;

import hello.hello_sprong.domain.Member;

public interface MemberRepotsitory {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();  
}
