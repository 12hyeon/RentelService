package hello.rentelservice.repository.member;

import hello.rentelservice.repository.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {
    private static Map<Long, Member> memberStore = new ConcurrentHashMap<>();
    private static AtomicLong memberCount = new AtomicLong(0);

    // member 1개 id로 찾기
    public Member findById(String id) {
        return memberStore.get(id);
    }

    // 전체 member 가져오기
    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    // member 저장
    public Member save(Member member) {
        member.setMemberId(memberCount.getAndIncrement());
        memberStore.put(member.getMemberId(), member);
        return member;
    }
}
