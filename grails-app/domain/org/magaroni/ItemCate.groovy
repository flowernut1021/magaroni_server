package org.magaroni

class ItemCate {

    String name
    String introduction

    static mapping = {
        table: 'item_cate'

        id generator: 'uuid'

        name column: 'name', sqlType: 'varchar(30)'
        introduction column: 'introduction', sqlType: 'varchar(500)'
    }

    static constraints = {
        name nullable: true, unique: false
        introduction nullable: true, unique: false
    }
}
