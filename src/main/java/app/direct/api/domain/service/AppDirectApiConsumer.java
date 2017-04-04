package app.direct.api.domain.service;

import app.direct.api.domain.company.Company;
import app.direct.api.domain.company.CompanyResponse;
import app.direct.api.domain.subscription.Order;
import app.direct.api.domain.subscription.OrderResponse;
import app.direct.api.domain.user.User;
import app.direct.api.domain.user.UserResponse;

public interface AppDirectApiConsumer {

    UserResponse userAdd(User user);

    CompanyResponse companyAdd(Company company);

    OrderResponse orderAdd(Order order);

    void orderDelete(String orderId);
}
