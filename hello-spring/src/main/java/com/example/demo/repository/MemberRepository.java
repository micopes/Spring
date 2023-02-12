package com.example.demo.repository;

import com.example.demo.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional - Scala의 모나드 같은 것인 듯. (Java 8부터 지원)
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
