package org.magaroni

import org.magaroni.conftype.JobLevel
import org.magaroni.conftype.TimeUnit

/**
 * TODO: could I use a enum, don't use a table.
 */
class ItemDetail {

    String name
    int serviceDuration
    TimeUnit serviceDurationUnit
    String effect
    BigDecimal price
    BigDecimal originalPrice
    JobLevel level
    String feature
    String symptom
    String forbiddenSymptom
    String additionalService
    String pic

    //TODO: foreign key
//    String item_cate_id
//    String technician_id

    static mapping = {
        table: 'item_detail'

        name column: 'name', sqlType: 'varchar(30)'
        serviceDuration column: 'service_duration', sqlType: 'int'
        serviceDurationUnit column: 'service_duration_unit', sqlType: 'varchar(20)'
        effect column: 'effect', sqlType: 'varchar(20)'
        price column: 'price', sqlType: 'double'
        originalPrice column: 'original_price', sqlType: 'double'
        level column: 'level', sqlType: 'varchar(20)'
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
        price nullable: true, unique: false
        originalPrice nullable: true, unique: false
        level nullable: true, unique: false
        feature nullable: true, unique: false
        symptom nullable: true, unique: false
        forbiddenSymptom nullable: true, unique: false
        additionalService nullable: true, unique: false
        pic nullable: true, unique: false
    }
}
