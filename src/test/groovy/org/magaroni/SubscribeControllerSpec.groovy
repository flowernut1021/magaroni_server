package org.magaroni

import grails.test.mixin.*
import spock.lang.*

@TestFor(SubscribeController)
@Mock(Subscribe)
class SubscribeControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.subscribeList
            model.subscribeCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.subscribe!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def subscribe = new Subscribe()
            subscribe.validate()
            controller.save(subscribe)

        then:"The create view is rendered again with the correct model"
            model.subscribe!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            subscribe = new Subscribe(params)

            controller.save(subscribe)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/subscribe/show/1'
            controller.flash.message != null
            Subscribe.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def subscribe = new Subscribe(params)
            controller.show(subscribe)

        then:"A model is populated containing the domain instance"
            model.subscribe == subscribe
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def subscribe = new Subscribe(params)
            controller.edit(subscribe)

        then:"A model is populated containing the domain instance"
            model.subscribe == subscribe
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/subscribe/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def subscribe = new Subscribe()
            subscribe.validate()
            controller.update(subscribe)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.subscribe == subscribe

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            subscribe = new Subscribe(params).save(flush: true)
            controller.update(subscribe)

        then:"A redirect is issued to the show action"
            subscribe != null
            response.redirectedUrl == "/subscribe/show/$subscribe.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/subscribe/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def subscribe = new Subscribe(params).save(flush: true)

        then:"It exists"
            Subscribe.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(subscribe)

        then:"The instance is deleted"
            Subscribe.count() == 0
            response.redirectedUrl == '/subscribe/index'
            flash.message != null
    }
}
