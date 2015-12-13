package org.magaroni

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SubscribeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Subscribe.list(params), model:[subscribeCount: Subscribe.count()]
    }

    def show(Subscribe subscribe) {
        respond subscribe
    }

    def create() {
        respond new Subscribe(params)
    }

    @Transactional
    def save(Subscribe subscribe) {
        if (subscribe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (subscribe.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond subscribe.errors, view:'create'
            return
        }

        subscribe.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subscribe.label', default: 'Subscribe'), subscribe.id])
                redirect subscribe
            }
            '*' { respond subscribe, [status: CREATED] }
        }
    }

    def edit(Subscribe subscribe) {
        respond subscribe
    }

    @Transactional
    def update(Subscribe subscribe) {
        if (subscribe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (subscribe.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond subscribe.errors, view:'edit'
            return
        }

        subscribe.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subscribe.label', default: 'Subscribe'), subscribe.id])
                redirect subscribe
            }
            '*'{ respond subscribe, [status: OK] }
        }
    }

    @Transactional
    def delete(Subscribe subscribe) {

        if (subscribe == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        subscribe.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subscribe.label', default: 'Subscribe'), subscribe.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subscribe.label', default: 'Subscribe'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
