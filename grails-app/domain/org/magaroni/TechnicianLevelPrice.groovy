package org.magaroni

import org.magaroni.conftype.CommonStatus
import org.magaroni.conftype.JobLevel

/**
 * Technician and item to determine the level (price)
 * //only one level_price row is valid in current time.
 *
 */
class TechnicianLevelPrice {

    TechnicianLevelPrice() {
        this.level = JobLevel.JUNIOR
        this.status = CommonStatus.VALID
        this.createTime = new Date()
    }

    Technician technician
    Item item

    JobLevel level
    BigDecimal price
    CommonStatus status
    Date createTime

    int starCount
    int orderCount

    static constraints = {
    }
}
