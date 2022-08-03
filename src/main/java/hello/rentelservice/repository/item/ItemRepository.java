package hello.rentelservice.repository.item;

import hello.rentelservice.repository.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository // @Component 내장됨
// DB 예외 처리 안함
public class ItemRepository {

    @Autowired
    private static Member member;

    private static Map<Long, Item> itemStore = new ConcurrentHashMap<>();
    private static AtomicLong itemCount = new AtomicLong(0);

    // item 1개 id로 찾기
    public Item findById(Long itemId) {
        return itemStore.get(itemId);
    }

    // 전체 item 가져오기
    public List<Item> findAll() {
        return new ArrayList<>(itemStore.values());
    }

    // item 저장
    public Item save(Item item) {
        item.setItemId(itemCount.getAndIncrement());
        itemStore.put(item.getItemId(), item);
        return item;
    }

    // item 수정
    public void update(Long itemId, ItemParam updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
    }
}
