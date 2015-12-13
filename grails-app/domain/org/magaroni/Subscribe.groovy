package org.magaroni

import org.magaroni.conftype.SubscribeStatus

class Subscribe {

    static belongsTo = [users: User, addresses: Address, items: Item, technicians: Technician]

    Subscribe() {
        this.status = SubscribeStatus.INIT
        this.createTime = new Date()
    }

    User user
    Address address
    Item item
    Technician technician

    Date startTime
    Date endTime
    SubscribeStatus status
    Date createTime

    static mapping = {
        table: 'subscribe'

        startTime column: 'start_time', sqlType: 'datetime'
        endTime column: 'end_time', sqlType: 'datetime'
        status column: 'status', sqlType: 'varchar(30)'
        createTime column: 'create_time', sqlType: 'datetime'

    }

    static constraints = {
        startTime nullable: true, unique: false
        endTime nullable: true, unique: false
        status nullable: true, unique: false
        createTime nullable: true, unique: false
    }
}
