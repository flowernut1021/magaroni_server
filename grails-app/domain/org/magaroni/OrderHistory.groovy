package org.magaroni

import org.magaroni.conftype.OrderStatus

class OrderHistory {
    static belongsTo = [orderFors: OrderFor]

    OrderHistory() {
        this.createDate = new Date();
    }

    OrderFor orderFor

    OrderStatus orderStatus
    String comments
    Date createDate


    static constraints = {
    }
}
