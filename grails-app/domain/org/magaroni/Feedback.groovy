package org.magaroni

class Feedback {

//    String userId  //foreign key
    String content

    static mapping = {
        table 'feedback'

        id generator: 'uuid'
        content	column: 'content', sqlType: 'varchar(1000)'
    }

    static constraints = {
        content nullable: true, unique: false
    }
}
