package org.magaroni

import org.magaroni.conftype.SubscribeStatus

class Subscribe {

    Subscribe() {
        this.status = SubscribeStatus.INIT
        this.createTime = new Date()
    }

//    user_id	foreign_key		预约人
//    address_id	foreign_key		地址
//    item_id	foreign_key		项目
//    tech_id	foreign_key		技师

    Date startTime
    Date endTime
    SubscribeStatus status
    Date createTime

    static mapping = {
        table: 'subscribe'

        startTime column: 'start_time', sqlType: 'datetime'
        endTime column: 'end_time', sqlType: 'datetime'
        status column: 'status', sqlType: 'varchar(30)'
        endTime column: 'create_time', sqlType: 'datetime'
    }

    static constraints = {
        startTime nullable: true, unique: false
        endTime nullable: true, unique: false
        status nullable: true, unique: false
        createTime nullable: true, unique: false
    }
}
