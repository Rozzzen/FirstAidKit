package com.zhuk.domain.order;

import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {

    private Long id;
    private User user;
    private List<FirstAidKit> firstAidKitList;
    //private Double totalPrice; transient

    public Order(User user, List<FirstAidKit> firstAidKitList) {
        this.user = user;
        this.firstAidKitList = firstAidKitList;
    }
}
