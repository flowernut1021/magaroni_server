package org.magaroni

import org.magaroni.conftype.CommonStatus


/**
 * 客户地址
 */
class Address {

    Address() {
        this.status = CommonStatus.VALID
    }

//    user_id	foreign_key
    String contact
    String contactTel
    CommonStatus status
    String cityCode
    String cityName

    static mapping = {
        table 'address'

        id generator: 'uuid'

        contact	column: 'contact', sqlType: 'varchar(30)', index: 'contact_Idx'
        contactTel column: 'contact_tel', sqlType: 'varchar(30)'
        status column: 'status', sqlType: 'varchar(20)'
        cityCode column: 'city_code', sqlType: 'varchar(30)'
        cityName column: 'city_name', sqlType: 'varchar(30)'
    }

    static constraints = {
        contact nullable: false, unique: false
        contactTel nullable: false, unique: false, matches: /\d+/
        status nullable: true, unique: false
        cityCode nullable: true, unique: false
        cityName nullable: true, unique: false
    }


}
