package org.magaroni

import org.magaroni.conftype.TimeUnit

/**
 * 项目表. 如 催乳, 按摩
 */
class Item {
    static hasMany = [technician : Technician, subscribes: Subscribe]

    String name
    int serviceDuration
    TimeUnit serviceDurationUnit
    String effect

    BigDecimal juniorPrice
    BigDecimal middlePrice
    BigDecimal seniorPrice

    BigDecimal juniorOriginPrice
    BigDecimal middleOriginPrice
    BigDecimal seniorOriginPrice

    String feature
    String symptom
    String forbiddenSymptom
    String additionalService
    String pic

    City city

    static mapping = {
        table: 'item'

        name column: 'name', sqlType: 'varchar(30)'
        serviceDuration column: 'service_duration', sqlType: 'int'
        serviceDurationUnit column: 'service_duration_unit', sqlType: 'varchar(20)'
        effect column: 'effect', sqlType: 'varchar(1000)'
        juniorPrice column: 'junior_price', sqlType: 'double'
        middlePrice column: 'middle_price', sqlType: 'double'
        seniorPrice column: 'senior_price', sqlType: 'double'
        juniorOriginPrice column: 'junior_origin_price', sqlType: 'double'
        middleOriginPrice column: 'middle_origin_price', sqlType: 'double'
        seniorOriginPrice column: 'senior_origin_price', sqlType: 'double'
        feature column: 'feature', sqlType: 'varchar(500)'
        symptom column: 'symptom', sqlType: 'varchar(500)'
        forbiddenSymptom column: 'forbidden_symptom', sqlType: 'varchar(500)'
        additionalService column: 'additional_service', sqlType: 'varchar(500)'
        pic column: 'pic', sqlType: 'varchar(200)'
    }

    static constraints = {
        name nullable: true, unique: false
        serviceDuration nullable: true, unique: false
        serviceDurationUnit nullable: true, unique: false
        effect nullable: true, unique: false
        juniorPrice nullable: true, unique: false
        middlePrice nullable: true, unique: false
        seniorPrice nullable: true, unique: false
        juniorOriginPrice nullable: true, unique: false
        middleOriginPrice nullable: true, unique: false
        seniorOriginPrice nullable: true, unique: false
        feature nullable: true, unique: false
        symptom nullable: true, unique: false
        forbiddenSymptom nullable: true, unique: false
        additionalService nullable: true, unique: false
        pic nullable: true, unique: false
    }
}
