package org.magaroni

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OrderForController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OrderFor.list(params), model:[orderForCount: OrderFor.count()]
    }

    def show(OrderFor orderFor) {
        respond orderFor
    }

    def create() {
        respond new OrderFor(params)
    }

    @Transactional
    def save(OrderFor orderFor) {
        if (orderFor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderFor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderFor.errors, view:'create'
            return
        }

        orderFor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderFor.label', default: 'OrderFor'), orderFor.id])
                redirect orderFor
            }
            '*' { respond orderFor, [status: CREATED] }
        }
    }

    def edit(OrderFor orderFor) {
        respond orderFor
    }

    @Transactional
    def update(OrderFor orderFor) {
        if (orderFor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (orderFor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orderFor.errors, view:'edit'
            return
        }

        orderFor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderFor.label', default: 'OrderFor'), orderFor.id])
                redirect orderFor
            }
            '*'{ respond orderFor, [status: OK] }
        }
    }

    @Transactional
    def delete(OrderFor orderFor) {

        if (orderFor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        orderFor.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderFor.label', default: 'OrderFor'), orderFor.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderFor.label', default: 'OrderFor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
