package org.magaroni

import org.magaroni.conftype.Gender
import org.magaroni.conftype.RoleType
import org.magaroni.conftype.UserStatus

class User {
    static belongsTo = City
    static hasMany = [cities: City, feedbacks: Feedback, subscribes: Subscribe, orderFors: OrderFor]

    User() {
        this.role = RoleType.CUSTOMER
        this.status = UserStatus.VALID
        this.timeStamp = new Date()
    }

    String phoneNumber
    String password
    RoleType role
    UserStatus status

    String name
    String nickName
    Gender gender
    String idNo
    String headPic
    String pic1
    String pic2
    String email

    String bodyCate
    String bodyFit
    String introduction

    Date timeStamp

    static mapping = {
        table 'user'

        phoneNumber column: 'phone_number', sqlType: 'varchar(30)', index: 'phoneNumber_Idx'
        password column: 'password', sqlType: 'varchar(30)'
        role column: 'role', sqlType: 'varchar(30)'
        status column: 'status', sqlType: 'varchar(30)'

        name column: 'name', sqlType: 'varchar(30)'
        nickName column: 'nick_name', sqlType: 'varchar(30)'
        gender column: 'gender', sqlType: 'varchar(8)'
        idNo column: 'id_no', sqlType: 'varchar(30)'
        headPic column: 'head_pic', sqlType: 'varchar(200)'
        pic1 column: 'pic1', sqlType: 'varchar(200)'
        pic2 column: 'pic2', sqlType: 'varchar(200)'
        email column: 'email', sqlType: 'varchar(50)'

        bodyCate column: 'body_cate', sqlType: 'varchar(10)'
        bodyFit column: 'body_fit', sqlType: 'varchar(30)'
        introduction column: 'introduction', sqlType: 'varchar(500)'

        timeStamp column: 'time_stamp', sqlType: 'date'
    }
    static constraints = {

        phoneNumber nullable: false, unique: true, matches: /\d+/
        password nullable: false, unique: false
        role nullable: true, unique: false
        status nullable: true, unique: false

        name nullable: true, unique: false
        nickName nullable: true, unique: false
        gender nullable: true, unique: false
        idNo nullable: true, unique: false
        headPic nullable: true, unique: false
        pic1 nullable: true, unique: false
        pic2 nullable: true, unique: false
        email nullable: true, unique: false, email: true

        bodyCate nullable: true, unique: false
        bodyFit nullable: true, unique: false
        introduction nullable: true, unique: false

        timeStamp nullable: true, unique: false
    }


}
