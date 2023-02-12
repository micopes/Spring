package repository;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

// 다른데서 안쓸거니까 public 안붙인다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 실행이 끝날 때마다 어떤 작업을 하는 것 (callback 메소드라고 보면 된다.) - 메소드(하나의 테스트)가 끝날 때마다 공용 데이터를 지워줘서 문제 없도록 동작.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // Assertions.assertEquals(member, result); // 두 인자(첫번째 인자: 기대하는 것 / 두번째 인자: 실제 값)가 같은지 검사. (다르면 오류 발생)
        assertThat(member).isEqualTo(result); // static import로 앞의 것 자동 제거 가능 | [Option(Alt) + Enter]

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 위의 것 붙여넣고 [Shift + F6]으로 전체 rename 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 위의 것 붙여넣고 [Shift + F6]으로 전체 rename 가능
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
