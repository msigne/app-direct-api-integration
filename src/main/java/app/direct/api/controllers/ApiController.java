package app.direct.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.direct.api.api.AppDirectApiConsumer;
import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.SubscriptionPayload;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.SubscriptionResponse;
import app.direct.api.domain.response.UserResponse;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    private final AppDirectApiConsumer api;

    @Autowired
    public ApiController(AppDirectApiConsumer api) {
        this.api = api;
    }

    @RequestMapping(value = "/companies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> companyAdd(@RequestBody CompanyPayLoad company) {
        final CompanyResponse r = api.companyAdd(company);
        return ResponseEntity.ok(r.toJson());
    }

    @RequestMapping(value = "/companies/{companyId}/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> userAdd(@RequestBody UserPayLoad user, @PathVariable String companyId) {
        final UserResponse r = api.userAdd(user, companyId);
        return ResponseEntity.ok(r.toJson());
    }

    @RequestMapping(value = "/companies/{companyId}/users/{userId}/subscriptions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> subscriptionAdd(@RequestBody SubscriptionPayload subscription, @PathVariable String companyId, @PathVariable String userId) {
        final SubscriptionResponse r = api.subscriptionAdd(subscription, companyId, userId);
        return ResponseEntity.ok(r.toJson());
    }

    @RequestMapping(value = "/subscriptions/{subscriptionId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> subscriptionCancel(@PathVariable String subscriptionId) {
        final Boolean r = api.subscriptionDelete(subscriptionId);
        return r ? ResponseEntity.ok("Subscription successfully canceled.") : ResponseEntity.ok("Subscription has not been canceled.");
    }
}