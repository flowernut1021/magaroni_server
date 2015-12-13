package org.magaroni

import org.magaroni.conftype.CommonStatus

/**
 * 技师
 */
class Technician {

    static belongsTo = [cities: City, items: Item]
    static hasMany = [items : Item, subscribes: Subscribe, commentses: Comments]

    Technician() {
        this.status = CommonStatus.VALID
        this.registerDate = new Date()
    }

    String name
    String password
    CommonStatus status
    String jobTel

    int jobYear  //工作年限
    int totalOrderCount //接单数
    String jobExperience
    String fitNo  //健康证号
    String fitPic
    String jobLicenseNo  //从业资格证号
    String jobLicensePic
    String serviceCircle //商圈

    BigDecimal jobWishSalary //期望薪资
    BigDecimal jobAveragePrice //均价

    Date registerDate

    static mapping = {
        table 'technician'

        name column: 'name', sqlType: 'varchar(30)', index: 'technician_name_Idx'
        jobTel column: 'job_tel', sqlType: 'varchar(30)', index: 'jobTel_Idx'
        password column: 'password', sqlType: 'varchar(30)'
        status column: 'status', sqlType: 'varchar(30)'

        jobYear column: 'job_year', defaultValue: 0
        totalOrderCount column: 'total_order_count', defaultValue: 0
        jobExperience column: 'job_experience', sqlType: 'varchar(1000)'
        fitNo column: 'fit_no', sqlType: 'varchar(30)'
        fitPic column: 'fit_pic', sqlType: 'varchar(200)'
        jobLicenseNo column: 'job_license_no', sqlType: 'varchar(30)'
        jobLicensePic column: 'job_license_pic', sqlType: 'varchar(200)'
        serviceCircle column: 'service_circle', sqlType: 'varchar(100)'

        jobWishSalary column: 'job_wish_salary', sqlType: 'double'
        jobAveragePrice column: 'job_average_price', sqlType: 'double'

        registerDate column: 'register_date', sqlType: 'datetime'
    }


    static constraints = {
        jobTel nullable: false, unique: true, matches: /\d+/
        password nullable: false, unique: false
        name nullable: true, unique: false
        status nullable: true, unique: false

        jobYear nullable: true, unique: false
        totalOrderCount nullable: true, unique: false
        jobExperience nullable: true, unique: false
        fitNo nullable: true, unique: false
        fitPic nullable: true, unique: false
        jobLicenseNo nullable: true, unique: false
        jobLicensePic nullable: true, unique: false
        serviceCircle nullable: true, unique: false

        jobWishSalary nullable: true, unique: false
        jobAveragePrice nullable: true, unique: false

        registerDate nullable: true, unique: false
    }
}
