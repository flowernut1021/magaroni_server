package org.magaroni

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TechnicianController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Technician.list(params), model:[technicianCount: Technician.count()]
    }

    def show(Technician technician) {
        respond technician
    }

    def create() {
        respond new Technician(params)
    }

    @Transactional
    def save(Technician technician) {
        if (technician == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (technician.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond technician.errors, view:'create'
            return
        }

        technician.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'technician.label', default: 'Technician'), technician.id])
                redirect technician
            }
            '*' { respond technician, [status: CREATED] }
        }
    }

    def edit(Technician technician) {
        respond technician
    }

    @Transactional
    def update(Technician technician) {
        if (technician == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (technician.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond technician.errors, view:'edit'
            return
        }

        technician.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'technician.label', default: 'Technician'), technician.id])
                redirect technician
            }
            '*'{ respond technician, [status: OK] }
        }
    }

    @Transactional
    def delete(Technician technician) {

        if (technician == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        technician.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'technician.label', default: 'Technician'), technician.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'technician.label', default: 'Technician'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
