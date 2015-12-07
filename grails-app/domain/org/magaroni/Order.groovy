package org.magaroni

import org.magaroni.conftype.OrderStatus
import org.magaroni.conftype.PayType

class Order {

    Order() {
        this.status = OrderStatus.INIT
        this.createTime = new Date()
    }
//    address_id	foreign_key
//    user_id	foreign_key
//    item_id	foreign_key

    String orderNo
    OrderStatus status
    BigDecimal shouldPrice
    BigDecimal orderPrice
    Date subscribeStartTime
    Date subscribeEndTime

    Date createTime

    PayType payType

    static mapping = {
        table: 'order'

        orderNo column: 'order_no', sqlType: 'varchar(100)'
        status column: 'status', sqlType: 'varchar(30)'
        shouldPrice column: 'should_price', sqlType: 'double'
        orderPrice column: 'order_price', sqlType: 'double'
        subscribeStartTime column: 'subscribe_start_time', sqlType: 'date'
        subscribeEndTime column: 'subscribe_end_time', sqlType: 'date'

        payType column: 'pay_type', sqlType: 'varchar(50)'
        createTime column: 'create_time', sqlType: 'date'
    }

    static constraints = {
        orderNo nullable: true, unique: false
        status nullable: true, unique: false
        shouldPrice nullable: true, unique: false
        orderPrice nullable: true, unique: false
        subscribeStartTime nullable: true, unique: false
        subscribeEndTime nullable: true, unique: false

        payType nullable: true, unique: false
        createTime nullable: true, unique: false

    }
}
