package org.magaroni

/**
 * {label:"北京Beijing010",name:"北京",pinyin:"Beijing",zip:"010"},
 {label:"重庆Chongqing023",name:"重庆",pinyin:"Chongqing",zip:"023"},
 {label:"上海Shanghai021",name:"上海",pinyin:"Shanghai",zip:"021"},
 */
class City {

    static hasMany = [users : User, technician : Technician, address: Address, items: Item]

    String zip
    String pinyin
    String name

    static constraints = {
    }
}
