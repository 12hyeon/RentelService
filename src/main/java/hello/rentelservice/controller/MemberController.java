package hello.rentelservice.controller;

import hello.rentelservice.repository.item.Item;
import hello.rentelservice.repository.item.ItemRepository;
import hello.rentelservice.repository.member.Member;
import hello.rentelservice.repository.member.MemberParam;
import hello.rentelservice.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member/login")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        memberRepository.save(new Member("id","pw"));
    }

    @GetMapping
    public String show_login() {
        return "member/login";
    }

    @PostMapping
    public String login(MemberParam memberParam, Model model) {
        // id 존재 & pw 일치 : 오류시 -> 해당 문자열 반환해서 알람 띄우기
        System.out.println("id : " + memberParam.getMemberId());
        System.out.println("password : " + memberParam.getPassword());

        Member member = memberRepository.findById(memberParam.getId());
        model.addAttribute("member",member);

        return "main/home";
    }

}
