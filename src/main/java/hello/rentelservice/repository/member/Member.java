package hello.rentelservice.repository.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class Member {
    private String id;
    private String password;
    private String nickname;
    private Long memberId; // 내부적으로 증가
    private Integer studentId; // 학생이면 학번
    private Integer grade;
    private String department;
    private String phoneNumber;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Member(String id, String password, String nickname,
                  Integer studentId, Integer grade, String department,
                  String phoneNumber, List<Long> items) {

        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.studentId = studentId;
        this.grade = grade;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }
}