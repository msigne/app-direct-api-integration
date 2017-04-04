package app.direct.api.api;

import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.OrderPayLoad;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.OrderResponse;
import app.direct.api.domain.response.UserResponse;

public interface AppDirectApiConsumer {

    /**
     * 
     * @param user
     * @return
     */
    UserResponse userAdd(UserPayLoad user, String companyId);

    /**
     * 
     * @param company
     * @return
     */
    CompanyResponse companyAdd(CompanyPayLoad company);

    /**
     * 
     * @param order
     * @return
     */
    OrderResponse orderAdd(OrderPayLoad order, String companyId, String userId);

    /**
     * 
     * @param orderId
     */
    Boolean orderDelete(String orderId);
}
