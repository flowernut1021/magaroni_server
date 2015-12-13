package org.magaroni

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TechnicianLevelPriceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TechnicianLevelPrice.list(params), model:[technicianLevelPriceCount: TechnicianLevelPrice.count()]
    }

    def show(TechnicianLevelPrice technicianLevelPrice) {
        respond technicianLevelPrice
    }

    def create() {
        respond new TechnicianLevelPrice(params)
    }

    @Transactional
    def save(TechnicianLevelPrice technicianLevelPrice) {
        if (technicianLevelPrice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (technicianLevelPrice.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond technicianLevelPrice.errors, view:'create'
            return
        }

        technicianLevelPrice.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'technicianLevelPrice.label', default: 'TechnicianLevelPrice'), technicianLevelPrice.id])
                redirect technicianLevelPrice
            }
            '*' { respond technicianLevelPrice, [status: CREATED] }
        }
    }

    def edit(TechnicianLevelPrice technicianLevelPrice) {
        respond technicianLevelPrice
    }

    @Transactional
    def update(TechnicianLevelPrice technicianLevelPrice) {
        if (technicianLevelPrice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (technicianLevelPrice.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond technicianLevelPrice.errors, view:'edit'
            return
        }

        technicianLevelPrice.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'technicianLevelPrice.label', default: 'TechnicianLevelPrice'), technicianLevelPrice.id])
                redirect technicianLevelPrice
            }
            '*'{ respond technicianLevelPrice, [status: OK] }
        }
    }

    @Transactional
    def delete(TechnicianLevelPrice technicianLevelPrice) {

        if (technicianLevelPrice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        technicianLevelPrice.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'technicianLevelPrice.label', default: 'TechnicianLevelPrice'), technicianLevelPrice.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'technicianLevelPrice.label', default: 'TechnicianLevelPrice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
