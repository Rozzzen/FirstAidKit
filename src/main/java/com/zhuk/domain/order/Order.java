package com.zhuk.domain.order;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private User user;
    private List<FirstAidKit> firstAidKitList;
    private Double totalPrice; //transient

    public Order(User user, List<FirstAidKit> firstAidKitList, Double totalPrice) {
        this.user = user;
        this.firstAidKitList = firstAidKitList;
        this.totalPrice = totalPrice;
    }
}
