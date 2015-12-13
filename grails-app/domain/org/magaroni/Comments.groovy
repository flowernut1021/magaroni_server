package org.magaroni

import org.magaroni.conftype.CommentsLevel
import org.magaroni.conftype.CommonStatus

/**
 * 评价 - 对技师
 */
class Comments {
    static belongsTo = [technicians: Technician, users: User]

    Comments() {
        this.contentLevel = CommentsLevel.GOOD
        this.commentDate = new Date()
        this.status = CommonStatus.INVALID
    }

    CommentsLevel contentLevel
    String content
    Date commentDate
    CommonStatus status

    Technician technician
    Item item
    User user

    static mapping = {
        table: 'comments'

        contentLevel column: 'content_level', sqlType: 'varchar(30)'
        content column: 'content', sqlType: 'varchar(1000)'
        commentDate column: 'comment_date', sqlType: 'datetime'
    }

    static constraints = {
        content nullable: true, unique: false
    }
}
