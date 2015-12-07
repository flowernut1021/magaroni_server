package org.magaroni

import org.magaroni.conftype.CommentsLevel

/**
 * 评价 - 对技师
 */
class Comments {

    Comments() {
        this.contentLevel = CommentsLevel.GOOD;
        this.commentDate = new Date();
    }

    CommentsLevel contentLevel
    String content
    Date commentDate
    //TODO: technician_id    //foreign_key

    static mapping = {
        table: 'comments'

        id generator: 'uuid'

        contentLevel column: 'content_level', sqlType: 'varchar(30)'
        content column: 'content', sqlType: 'varchar(1000)'
        commentDate column: 'comment_date', sqlType: 'date'
    }

    static constraints = {
        content nullable: true, unique: false
    }
}
