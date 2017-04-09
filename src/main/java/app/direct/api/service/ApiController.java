package app.direct.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.direct.api.consumer.AppDirectApiConsumer;
import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.SubscriptionPayload;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.SubscriptionResponse;
import app.direct.api.domain.response.UserResponse;

/**
 * Expose some AppDirect Api operations as rest service.
 * 
 * @author Martin Blaise Signe.
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    private final AppDirectApiConsumer api;

    @Autowired
    public ApiController(AppDirectApiConsumer api) {
        this.api = api;
    }

    /**
     * Exposes the Company creation operation.
     * 
     * @param company company to create.
     * @return An Http response that contain the created company information as a body.
     */
    @RequestMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> companyAdd(@RequestBody CompanyPayLoad company) {
        try {
            final CompanyResponse r = api.companyAdd(company);
            return ResponseEntity.ok(r.toJson());
        } catch (Exception e) {
            LOGGER.error("Failed to add the company. message ={}. ", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Exposes the user creation operation.
     * 
     * @param user user to create.
     * @return An Http response that contain the created user information as a body.
     */
    @RequestMapping(value = "/companies/{companyId}/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> userAdd(@RequestBody UserPayLoad user, @PathVariable String companyId) {
        try {
            final UserResponse r = api.userAdd(user, companyId);
            return ResponseEntity.ok(r.toJson());
        } catch (Exception e) {
            LOGGER.error("Failed to add the user. message ={}. ", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Exposes the subscription creation operation.
     * 
     * @param subscription Subscription to create.
     * @return An Http response that contain the created subscription information as a body.
     */
    @RequestMapping(value = "/companies/{companyId}/users/{userId}/subscriptions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    method = RequestMethod.POST)
    public ResponseEntity<String> subscriptionAdd(@RequestBody SubscriptionPayload subscription, @PathVariable String companyId,
                                                  @PathVariable String userId) {
        try {
            final SubscriptionResponse r = api.subscriptionAdd(subscription, companyId, userId);
            return ResponseEntity.ok(r.toJson());
        } catch (Exception e) {
            LOGGER.error("Failed to add the subscription. message ={}. ", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Exposes the subscription cancel operation.
     * 
     * @param subscriptionId Subscription identifier.
     * @return
     */
    @RequestMapping(value = "/subscriptions/{subscriptionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> subscriptionCancel(@PathVariable String subscriptionId) {
        try {
            final Boolean r = api.subscriptionCancel(subscriptionId);
            return r ? ResponseEntity.ok("Subscription successfully canceled.") : ResponseEntity.ok("Subscription has not been canceled.");
        } catch (Exception e) {
            LOGGER.error("Failed to cancel the subscription. message ={}. ", e.getMessage(), e);
            throw e;
        }
    }
}
