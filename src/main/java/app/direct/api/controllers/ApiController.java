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
import app.direct.api.domain.payload.OrderPayLoad;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.OrderResponse;
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

    @RequestMapping(value = "/companies/{companyId}/users/{userId}/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> userAdd(@RequestBody OrderPayLoad order, @PathVariable String companyId, @PathVariable String userId) {
        final OrderResponse r = api.orderAdd(order, companyId, userId);
        return ResponseEntity.ok(r.toJson());
    }

    @RequestMapping(value = "/orders/{orderId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<String> userAdd(@PathVariable String orderId) {
        final Boolean r = api.orderDelete(orderId);
        return r ? ResponseEntity.ok("Order successfully canceled.") : ResponseEntity.ok("Order has not been canceled.");
    }

}
