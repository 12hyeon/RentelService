package hello.rentelservice.controller;

import hello.rentelservice.repository.item.Item;
import hello.rentelservice.repository.item.ItemRepository;
import hello.rentelservice.repository.member.Member;
import hello.rentelservice.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final Member member = new Member("id","pw");

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("이름1","id", 10000,"설명",
                "2022-07-29","2022-07-30"));
        itemRepository.save(new Item("이름2","id2", 10000,"설명",
                "2022-07-29","2022-07-30"));
    }

    @GetMapping("/home")
    public List<Item> showItem(Member member) {
        List<Item> store = itemRepository.findAll();
        // List<Item> memberItem = new ArrayList<>();
        /*for (item:store) {
            if (item.findById(member.getId())) {
                memberItem.add(item);
            }
        }*/
        return store;
    }
}
