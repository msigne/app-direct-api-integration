package app.direct.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import app.direct.api.domain.company.Company;
import app.direct.api.domain.company.CompanyResponse;
import app.direct.api.domain.subscription.Order;
import app.direct.api.domain.subscription.OrderResponse;
import app.direct.api.domain.user.User;
import app.direct.api.domain.user.UserResponse;
import app.direct.api.helper.HttpHelper;
import app.direct.api.helper.SerializerHelper;

@Component
public class DefaultAppDirectApiConsumer implements AppDirectApiConsumer {

    private static final String API_PATH = "https://appdirect.com/api/account/v1/";
    private final HttpHelper<String> httpHelper;

    @Autowired
    public DefaultAppDirectApiConsumer(HttpHelper<String> httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public UserResponse userAdd(User user) {
        return null;
    }

    @Override
    public CompanyResponse companyAdd(Company company) {
        final String payLoad = company.toJson();
        final String path = API_PATH+"/companies";
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad, String.class, null);
        return SerializerHelper.deserialized(response.getBody(), CompanyResponse.class);
    }

    @Override
    public OrderResponse orderAdd(Order order) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void orderDelete(String orderId) {
        // TODO Auto-generated method stub

    }

}
