package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); // DI(Dependency Injection) - 외부에서 넣어주는 것.
    }

    @AfterEach // 메소드가 실행이 끝날 때마다 어떤 작업을 하는 것 (callback 메소드라고 보면 된다.) - 메소드(하나의 테스트)가 끝날 때마다 공용 데이터를 지워줘서 문제 없도록 동작.
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given - 주어진 것
        Member member = new Member();
        member.setName("hello");

        //when - 실행 할 때
        Long saveId = memberService.join(member);

        //then - 나와야 할 결과 (기대 결과)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*
        // 방법 1. try - catch 이용
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123123");
        }
*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}