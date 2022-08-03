package hello.rentelservice.repository.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Item {

    private Long itemId;
    private Long memberId;
    private String itemName;
    private Integer price;
    private String description;
    private String startDate;
    private String endDate;

    public Item() {
    }

    public Item(String itemName, String memberId, Integer price, String description, String startDate, String endDate) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}