package org.magaroni

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrderHistoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OrderHistory.list(params), model:[orderHistoryCount: OrderHistory.count()]
    }

    def show(OrderHistory orderHistory) {
        respond orderHistory
    }

    def create() {
        respond new OrderHistory(params)
    }

    @Transactional
    def save(OrderHistory orderHistory) {
        if (orderHistory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderHistory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderHistory.errors, view:'create'
            return
        }

        orderHistory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderHistory.label', default: 'OrderHistory'), orderHistory.id])
                redirect orderHistory
            }
            '*' { respond orderHistory, [status: CREATED] }
        }
    }

    def edit(OrderHistory orderHistory) {
        respond orderHistory
    }

    @Transactional
    def update(OrderHistory orderHistory) {
        if (orderHistory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderHistory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderHistory.errors, view:'edit'
            return
        }

        orderHistory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderHistory.label', default: 'OrderHistory'), orderHistory.id])
                redirect orderHistory
            }
            '*'{ respond orderHistory, [status: OK] }
        }
    }

    @Transactional
    def delete(OrderHistory orderHistory) {

        if (orderHistory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        orderHistory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderHistory.label', default: 'OrderHistory'), orderHistory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderHistory.label', default: 'OrderHistory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
