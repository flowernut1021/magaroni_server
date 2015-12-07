package org.magaroni

import org.magaroni.conftype.SubscribeStatus

class Subscribe {

    Subscribe() {
        this.status = SubscribeStatus.INIT;
    }

//    user_id	foreign_key		预约人
//    address_id	foreign_key		地址
//    item_id	foreign_key		项目
//    tech_id	foreign_key		技师

    Date startTime
    Date endTime
    SubscribeStatus status

    static mapping = {
        table: 'subscribe'

        id generator: 'uuid'

        startTime column: 'start_time', sqlType: 'date'
        endTime column: 'end_time', sqlType: 'date'
        status column: 'status', sqlType: 'varchar(30)'
    }

    static constraints = {
        startTime nullable: true, unique: false
        endTime nullable: true, unique: false
        status nullable: true, unique: false
    }
}
