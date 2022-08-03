package hello.rentelservice.repository.member;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class MemberParam {

    private String id;
    private String password;
    private Long memberId; // 내부적으로 증가

    public MemberParam(String id, String password) {
        this.id = id;
        this.password = password;
    }

}

