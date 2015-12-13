package org.magaroni

/**
 * who(user) give the feedback
 */
class Feedback {

    Feedback() {
        this.createTime = new Date();
    }

    String content
    Date createTime

    static mapping = {
        table 'feedback'

        content	column: 'content', sqlType: 'varchar(1000)'
        createTime column: 'create_time', sqlType: 'datetime'
    }

    static constraints = {
        content nullable: true, unique: false
    }
}
