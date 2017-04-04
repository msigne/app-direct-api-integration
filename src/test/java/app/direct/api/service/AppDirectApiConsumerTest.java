package app.direct.api.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.direct.api.api.AppDirectApiConsumer;
import app.direct.api.api.DefaultAppDirectApiConsumer;
import app.direct.api.domain.Address;
import app.direct.api.domain.Company;
import app.direct.api.domain.Contact;
import app.direct.api.domain.Order;
import app.direct.api.domain.OrderLine;
import app.direct.api.domain.User;
import app.direct.api.domain.enumeration.Attributes;
import app.direct.api.domain.enumeration.LineType;
import app.direct.api.domain.enumeration.Size;
import app.direct.api.domain.enumeration.Title;
import app.direct.api.domain.enumeration.UserStatus;
import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.OrderPayLoad;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.OrderResponse;
import app.direct.api.domain.response.UserResponse;
import app.direct.api.helper.HttpHelper;

@RunWith(MockitoJUnitRunner.class)
public class AppDirectApiConsumerTest {

    @Mock
    private HttpHelper<String> http;
    private AppDirectApiConsumer api;
    private Company company;
    private User user;
    private Order order;

    @Before
    public void setup() {
        api = new DefaultAppDirectApiConsumer(http);
        company = Company.builder().address(Address.builder().build()).attributes(Attributes.ABN_ACN).contact(Contact.builder().build())
                .emailAddress("mb@mycompany.com").enabled(true).industry("Industry").name("My company").size(Size.ENTERPRISE)
                .website("https://www.test.com").build();
        user = User.builder().contact(Contact.builder().build()).email("user@localhost").firstName("firstName").language("English").lastName("last-name")
                .openId("open-id").registrationCode("registration-code").status(UserStatus.ACTIVE).title(Title.MR).build();
        order = simpleOrder();
    }

    @Test
    public void testCompanyAddSuccess() {
        final CompanyResponse cr = new CompanyResponse(company);
        cr.setCreationDate("2016-04-04");
        final CompanyPayLoad cp = new CompanyPayLoad(company);

        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED).body(cr.toJson());
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        final CompanyResponse cresponse = api.companyAdd(cp);
        verify(http, times(1)).doPost(anyString(), eq(cp.toJson()), any(), anyString());
        assertThat(cr.toJson(), is(cresponse.toJson()));
    }

    @Test(expected = RuntimeException.class)
    public void testCompanyAddFail() {
        final CompanyPayLoad cp = new CompanyPayLoad(company);
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CONFLICT).body("The company already exist");
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        api.companyAdd(cp);
        verify(http, times(1)).doPost(anyString(), eq(cp.toJson()), any(), anyString());
    }

    @Test
    public void testUserAddSuccess() {
        final UserResponse ur = new UserResponse(user);
        ur.setCreationDate("2016-04-04");
        final UserPayLoad up = new UserPayLoad(user);
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED).body(ur.toJson());
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        final UserResponse cresponse = api.userAdd(up, "company-id");
        verify(http, times(1)).doPost(anyString(), eq(up.toJson()), any(), anyString());
        assertThat(ur.toJson(), is(cresponse.toJson()));
    }

    @Test(expected = RuntimeException.class)
    public void testUserAddFail() {
        final UserPayLoad up = new UserPayLoad(user);
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CONFLICT).body("The user already exist.");
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        api.userAdd(up, "company-id");
        verify(http, times(1)).doPost(anyString(), eq(up.toJson()), any(), anyString());
    }

    @Test
    public void testOrderAddSuccess() {
        final OrderResponse or = new OrderResponse(order);
        or.setCreationDate("2016-04-04");
        final OrderPayLoad op = new OrderPayLoad(order);

        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED).body(or.toJson());
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        final OrderResponse cresponse = api.orderAdd(op, "company-id", "user-id");
        verify(http, times(1)).doPost(anyString(), eq(op.toJson()), any(), anyString());
        assertThat(or.toJson(), is(cresponse.toJson()));
    }

    @Test(expected = RuntimeException.class)
    public void testOrderAddFail() {
        final OrderPayLoad op = new OrderPayLoad(order);
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CONFLICT).body("Order already exist");
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        api.orderAdd(op, "company-id", "user-id");
        verify(http, times(1)).doPost(anyString(), eq(op.toJson()), any(), anyString());
    }
    
    
    @Test
    public void testOrderDeleteSuccess() {
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order successfully canceled");
        when(http.doDelete(anyString(), any(), anyString())).thenReturn(response);
        final Boolean result = api.orderDelete("order-Id");
        verify(http, times(1)).doDelete(anyString(), any(), anyString());
        assertThat(result, is(true));
    }

    @Test
    public void testOrderDeleteFail() {
        final ResponseEntity<String> response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        when(http.doPost(anyString(), any(), any(), anyString())).thenReturn(response);
        when(http.doDelete(anyString(), any(), anyString())).thenReturn(response);
        final Boolean result = api.orderDelete("order-Id");
        verify(http, times(1)).doDelete(anyString(), any(), anyString());
        assertThat(result, is(false));
    }

    
    

    /**
     * Build a simple order for testing purposes.
     * 
     * @return The built order.
     */
    private Order simpleOrder() {
        final List<OrderLine> lines =
                Arrays.asList(OrderLine.builder().description("item1").percentage(0.19).price(2.00).quantity(3.0).type(LineType.ITEM).build(),
                        OrderLine.builder().description("item2").percentage(0.19).price(10.00).quantity(2.0).type(LineType.ITEM).build(),
                        OrderLine.builder().description("item3").percentage(0.19).price(2.00).quantity(8.0).type(LineType.ITEM).build());

        return Order.builder().discountId("discount-id").orderLines(lines).paymentPlanId("payment-plan-id").build();
    }

}
