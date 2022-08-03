package hello.rentelservice.repository.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemParam {

    private String itemName;
    private Integer price;
    private String description;
    private String startDate;
    private String endDate;

    public ItemParam() {
    }

    public ItemParam(String itemName, Integer price, String description, String startDate, String endDate) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}

